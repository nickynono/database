import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class DeleteGPU {

	public static void DeleteGPU(int buildNum, final Connection con){
		
		int row = 2;
		int col = 2;
		
		int loginW = col*100;
		int loginH = row*40;
		
		System.out.println("Delete GPU");
		
		final JFrame frame = new JFrame("Delete GPU");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		final JTextField PIDTxt =  new JTextField();
		
		JButton exitBut = new JButton("Exit");
		exitBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();	    	}       
	    });
		
		
		JButton delBut = new JButton("Delete");
		delBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
		
				if(PIDTxt.getText().isEmpty()==true){
					JOptionPane.showMessageDialog(frame, "Invalid or missing information", "Error" ,JOptionPane.ERROR_MESSAGE);
				}
				else{	
					String quer = "EXECUTE deleteGPU ?";
					try {
					CallableStatement c = con.prepareCall(quer);
					c.setInt(1, new Integer(PIDTxt.getText()));
					c.execute();
					frame.dispose();
					} catch (SQLException | NumberFormatException e) {
						JOptionPane.showMessageDialog(frame, "Part not Deleted", "Error" ,JOptionPane.ERROR_MESSAGE);
					}
				}	    
			}
	    	});
		
		
		frame.setLayout(new GridLayout(row,col,2,3));
		
		frame.add(new JLabel("Part ID"));
		frame.add(exitBut);
		
		frame.add(PIDTxt);
		frame.add(delBut);
						
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(((int)screenSize.getWidth()/2)-(loginW/2), ((int)screenSize.getHeight()/2)-(loginH/2), loginW, loginH);
		frame.setResizable(false);
		frame.setVisible(true); 
	}
}