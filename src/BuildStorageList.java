import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.*;

import javax.swing.*;

public class BuildStorageList {
	
	public static void BuildStorageList(final int buildNum){
		
		int width = 400;
		int height = 780;
		
		final JFrame frame = new JFrame("BUILD NAME HERE");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
		JButton exitBut = new JButton("Exit");
		exitBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				OldBuildList.OldBuildList(buildNum);
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	    	}       
	    });
		
		JButton storage1But = new JButton("Storage 1");
		storage1But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton storage2But = new JButton("Storage 2");
		storage2But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton storage3But = new JButton("Storage 3");
		storage3But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton storage4But = new JButton("Storage 4");
		storage4But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton storage5But = new JButton("Storage 5");
		storage5But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton storage6But = new JButton("Storage 6");
		storage6But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton storage7But = new JButton("Storage 7");
		storage7But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton storage8But = new JButton("Storage 8");
		storage8But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton storage9But = new JButton("Storage 9");
		storage9But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton storage10But = new JButton("Storage 10");
		storage10But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		

		frame.setLayout(new GridLayout(11, 2, 3, 3));

		frame.add(new JLabel());
		frame.add(exitBut);
		frame.add(new JLabel("Storage 1"));
		frame.add(storage1But);
		frame.add(new JLabel("Storage 2"));
		frame.add(storage2But);
		frame.add(new JLabel("Storage 3"));
		frame.add(storage3But);
		frame.add(new JLabel("Storage 4"));
		frame.add(storage4But);
		frame.add(new JLabel("Storage 5"));
		frame.add(storage5But);
		frame.add(new JLabel("Storage 6"));
		frame.add(storage6But);
		frame.add(new JLabel("Storage 7"));
		frame.add(storage7But);
		frame.add(new JLabel("Storage 8"));
		frame.add(storage8But);
		frame.add(new JLabel("Storage 9"));
		frame.add(storage9But);
		frame.add(new JLabel("Storage 10"));
		frame.add(storage10But);
	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(((int)screenSize.getWidth()/2)-(width/2), ((int)screenSize.getHeight()/2)-(height/2), width, height);
		
		frame.setResizable(false);
		frame.setVisible(true);
		
		}
		
	}

