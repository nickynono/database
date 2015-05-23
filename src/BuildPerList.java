import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.*;

import javax.swing.*;

public class BuildPerList {
	
	public static void BuildPerList(final int buildNum){
		
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
		
		JButton peripheral1But = new JButton("Peripheral 1");
		peripheral1But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton peripheral2But = new JButton("Peripheral 2");
		peripheral2But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton peripheral3But = new JButton("Peripheral 3");
		peripheral3But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton peripheral4But = new JButton("Peripheral 4");
		peripheral4But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton peripheral5But = new JButton("Peripheral 5");
		peripheral5But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton peripheral6But = new JButton("Peripheral 6");
		peripheral6But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton peripheral7But = new JButton("Peripheral 7");
		peripheral7But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton peripheral8But = new JButton("Peripheral 8");
		peripheral8But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton peripheral9But = new JButton("Peripheral 9");
		peripheral9But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton peripheral10But = new JButton("Peripheral 10");
		peripheral10But.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		

		frame.setLayout(new GridLayout(11, 2, 3, 3));

		frame.add(new JLabel());
		frame.add(exitBut);
		frame.add(new JLabel("Peripheral 1"));
		frame.add(peripheral1But);
		frame.add(new JLabel("Peripheral 2"));
		frame.add(peripheral2But);
		frame.add(new JLabel("Peripheral 3"));
		frame.add(peripheral3But);
		frame.add(new JLabel("Peripheral 4"));
		frame.add(peripheral4But);
		frame.add(new JLabel("Peripheral 5"));
		frame.add(peripheral5But);
		frame.add(new JLabel("Peripheral 6"));
		frame.add(peripheral6But);
		frame.add(new JLabel("Peripheral 7"));
		frame.add(peripheral7But);
		frame.add(new JLabel("Peripheral 8"));
		frame.add(peripheral8But);
		frame.add(new JLabel("Peripheral 9"));
		frame.add(peripheral9But);
		frame.add(new JLabel("Peripheral 10"));
		frame.add(peripheral10But);
	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(((int)screenSize.getWidth()/2)-(width/2), ((int)screenSize.getHeight()/2)-(height/2), width, height);
		
		frame.setResizable(false);
		frame.setVisible(true);
		
		}
		
	}

