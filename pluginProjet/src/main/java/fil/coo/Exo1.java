package fil.coo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Exo1 {
	public Exo1() {
		//timer est l'emmetteur
	    ActionListener al=new MyActionListener();
	    Timer timer = new Timer(1000, null);	
	    //abonnement des listeners
	    timer.addActionListener(al);

	    timer.start(); // demarrer le timer 
	}

	//class d'un listener
	private class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
					System.out.println(java.util.Calendar.getInstance().getTime());			
		}
	}
//	
//	private class MyActionListener2 implements ActionListener{
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//					System.out.println("pong");			
//		}
//	}
	
	
	public static void main(String[] args){
		new Exo1();
		while(true);
	}
}
