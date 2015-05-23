import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.*;

import javax.swing.*;

public class CompleteBuild {
	
	public static void CompleteBuild(final int buildNum){
		
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
		
		JButton viewCPUBut = new JButton("View CPU");
		viewCPUBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton viewMoboBut = new JButton("View Motherboard");
		viewMoboBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton viewGPUBut = new JButton("View GPU");
		viewGPUBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton viewRAMBut = new JButton("View RAM");
		viewRAMBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton viewPSUBut = new JButton("View PSU");
		viewPSUBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton viewCPUCoolBut = new JButton("View CPU Cooler");
		viewCPUCoolBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton viewCaseBut = new JButton("View Case");
		viewCaseBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton viewMonBut = new JButton("View Monitor");
		viewMonBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
	    	}       
	    });
		JButton viewStorBut = new JButton("View Storage List");
		viewStorBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				BuildStorageList.BuildStorageList(buildNum);
	    	}       
	    });
		
		JButton viewPerBut = new JButton("View Peripheral List");
		viewPerBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				BuildPerList.BuildPerList(buildNum);
	    	}       
	    });
		

		frame.setLayout(new GridLayout(11, 2, 3, 3));

		frame.add(new JLabel());
		frame.add(exitBut);
		frame.add(new JLabel("CPU"));
		frame.add(viewCPUBut);
		frame.add(new JLabel("Motherboard"));
		frame.add(viewMoboBut);
		frame.add(new JLabel("GPU"));
		frame.add(viewGPUBut);
		frame.add(new JLabel("RAM"));
		frame.add(viewRAMBut);
		frame.add(new JLabel("PSU"));
		frame.add(viewPSUBut);
		frame.add(new JLabel("CPU Cooler"));
		frame.add(viewCPUCoolBut);
		frame.add(new JLabel("Case"));
		frame.add(viewCaseBut);
		frame.add(new JLabel("Monitor"));
		frame.add(viewMonBut);
		frame.add(new JLabel("Storage List"));
		frame.add(viewStorBut);
		frame.add(new JLabel("Peripheral List"));
		frame.add(viewPerBut);
	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(((int)screenSize.getWidth()/2)-(width/2), ((int)screenSize.getHeight()/2)-(height/2), width, height);
		
		frame.setResizable(false);
		frame.setVisible(true);
		
		}
		
	}

