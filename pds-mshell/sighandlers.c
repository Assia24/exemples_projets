/* mshell - a job manager */

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <signal.h>
#include <sys/wait.h>
#include <errno.h>
#include <assert.h>


#include "jobs.h"
#include "common.h"
#include "sighandlers.h"

/*
 * wrapper for the sigaction function
 */
int sigaction_wrapper(int signum, handler_t * handler) {
  struct sigaction action;
  action.sa_handler=handler;
  sigemptyset(&action.sa_mask);
  action.sa_flags=0;
  assert( sigaction(signum,&action,NULL)!=EXIT_FAILURE);
}

/*
 * sigchld_handler - The kernel sends a SIGCHLD to the shell whenever
 *     a child job terminates (becomes a zombie), or stops because it
 *     received a SIGSTOP or SIGTSTP signal. The handler reaps all
 *     available zombie children
 */
void sigchld_handler(int sig) {
   struct job_t *stpJob;
   int pid;
   int status;
    if (verbose)
        printf("sigchld_handler: entering\n");


    pid=waitpid(-1,&status,WNOHANG|WUNTRACED);

    if (WIFEXITED(status)) {
      jobs_deletejob(pid);
    }

    if (WIFSTOPPED(status)) {
      stpJob = jobs_getjobpid(pid);
      stpJob -> jb_state = ST;
    }

    /*
    assert(sig=SIGCHLD);
    while(stpJobs=jobs_getstoppedjob()!=NULL){
      if(pid=stpJobs.jb_pid!=NULL)
	kill(pid,sig);
    */
    
    if (verbose)
        printf("sigchld_handler: exiting\n");

    return;
}

/*
 * sigint_handler - The kernel sends a SIGINT to the shell whenver the
 *    user types ctrl-c at the keyboard.  Catch it and send it along
 *    to the foreground job.
 */
void sigint_handler(int sig) {
  int pid;
    if (verbose)
        printf("sigint_handler: entering\n");
    assert(sig=SIGINT);
    if (pid =jobs_fgpid()!=0)
      kill(pid,sig);

    if (verbose)
        printf("sigint_handler: exiting\n");

    return;
}

/*
 * sigtstp_handler - The kernel sends a SIGTSTP to the shell whenever
 *     the user types ctrl-z at the keyboard. Catch it and suspend the
 *     foreground job by sending it a SIGTSTP.
 */
void sigtstp_handler(int sig) {
  int pid;
    if (verbose)
        printf("sigtstp_handler: entering\n");

    assert(sig=SIGTSTP);
    if ((pid = jobs_fgpid()) !=0)
      kill(pid,sig);

    if (verbose)
        printf("sigtstp_handler: exiting\n");

    return;
}
