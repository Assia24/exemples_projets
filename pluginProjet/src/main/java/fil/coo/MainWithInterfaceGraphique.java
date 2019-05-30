package fil.coo;
import java.awt.*;
import javax.swing.*;

import plugin.PluginFilter;

import java.awt.event.*;
import java.io.FilenameFilter;

public class MainWithInterfaceGraphique {
	
	private JButton aButton;
	private JLabel aLabel;
	private JMenuBar menubar;
	private JMenu menuFile;
	private JMenu menuTools;
	private JMenu menuHelp;
	private JMenuItem menuItem1;
	private JMenuItem menuItem2;
	private JMenuItem menuItem3;
	private JPanel panel;
	private JPanel panel1;
	private JTextArea aTextArea;
	private JScrollPane aScrollPane;
	
	public void fenetre() {
		JFrame f = new JFrame("Plugin Project");
		f.setLocation(100, 300);
		f.setSize(100, 100);

		f.setLayout(new BorderLayout());

		
		menubar=new JMenuBar();
		menuFile = new JMenu("File");
		menuTools = new JMenu("Tools");
		menuHelp = new JMenu("Help");
		menuItem1 = new JMenuItem();
		menuItem2 = new JMenuItem();
		menuItem3 = new JMenuItem();
		panel1=new JPanel();
		aTextArea = new JTextArea();
		aScrollPane= new JScrollPane();
		
		menubar.add(menuFile);
		menubar.add(menuTools);
		menubar.add(menuHelp);
		
		menuFile.add(menuItem1);
		menuTools.add(menuItem2);
		menuHelp.add(menuItem3);
		
		f.add(aTextArea, BorderLayout.CENTER);
		f.setJMenuBar(menubar);
		

		f.pack();
		f.setVisible(true);
		
		FilenameFilter ff= new PluginFilter();
		FileListener fl=new PluginListener();
		FileChecker fc= new FileChecker(ff,"dossPlugin");
		fc.addFileListener(fl);
	}
	
	public static void main(String[] args) {
		new MainWithInterfaceGraphique().fenetre();
	}
	
	private class CloseWindowEvent extends WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent e) {
			System.exit(0);
		}
	}
	
	private class PluginListener implements FileListener{

		@Override
		public void fileAdded(FileEvent fe) {
			JMenuItem mi= new JMenuItem();
			mi.setText(fe.getLabel());
			MainWithInterfaceGraphique.this.menuTools.add(mi);
			
		}

		@Override
		public void fileRemoved(FileEvent fe) {
			JMenuItem mi= new JMenuItem();
			mi.setText(fe.getLabel());
			MainWithInterfaceGraphique.this.menuTools.remove(mi);
			
		}
		
	}

	
	

	

}
