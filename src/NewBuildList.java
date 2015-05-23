import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


/*
 *  This is an unused class.  Originally this was to display the parts of a new build.  It had been replaced by a message in MainScreen giving the new build number.
 */

public class NewBuildList {
	
	public static void NewBuildList(int buildNum){
		
		int col = 9;
		int row = 10;
		
		int loginW = col*100;
		int loginH = row*25;
		
		System.out.println("Create a new build");
		System.out.println(buildNum);
		
		final JFrame frame = new JFrame("Create a new build");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton exitBut = new JButton("Exit");
		exitBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();	    	}       
	    });
		
		frame.add(exitBut);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(((int)screenSize.getWidth()/2)-(loginW/2), ((int)screenSize.getHeight()/2)-(loginH/2), loginW, loginH);
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
