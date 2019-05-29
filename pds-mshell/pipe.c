/* mshell - a job manager */

#include <stdio.h>
#include "pipe.h"

void do_pipe(char *cmds[MAXCMDS][MAXARGS], int nbcmd, int bg) {
  /*  char ** argv1;
  char ** argv2;
  int fd[2];
  int pipe;

  pipe=pipe(&fd);
  switch(fork()){
  case -1:
    exit(EXIT_FAILURE);
  case 0:
    close(fd[0]);
    assert(dup2(fd[1],STDOUT_FILENO!=-1));
    close(fd[1]);
    execvp(argv1[0],argv1);
    exit(EXIT_FAILURE);
  default :
    ;
  }

  switch(fork()){
  case -1:
    exit(EXIT_FAILURE);
  case 0:
    close(fd[1]);
    assert(dup2(fd[0],STDIN)!=-1);
    close(fd[0]);
    execvp(&argv2);
    exit(EXIT_FAILURE);
  }
  close(fd[1]);
  close(fd[0]);
  wait(NULL);
  wait(NULL);
  */

  return;
}
