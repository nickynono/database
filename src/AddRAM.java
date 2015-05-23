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


public class AddRAM {

	public static void AddRAM(int buildNum, final Connection con){
		
		int row = 2;
		int col = 8;
		
		int loginW = col*100;
		int loginH = row*40;
		
		System.out.println("Add RAM");
		
		final JFrame frame = new JFrame("Add RAM");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		final JTextField nameTxt =  new JTextField();
		final JTextField totalTxt =  new JTextField();
		final JTextField stickTxt =  new JTextField();
		final JTextField stickNumTxt =  new JTextField();
		final JTextField speedTxt =  new JTextField();
		final JTextField powTxt =  new JTextField();
		final JTextField manufacturerTxt =  new JTextField();
		final JTextField vendorTxt =  new JTextField();
		final JTextField priceTxt =  new JTextField();
		
		JButton exitBut = new JButton("Exit");
		exitBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();	    	}       
	    });
		
		
		JButton addBut = new JButton("Add");
		addBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
		
				if(nameTxt.getText().isEmpty()==true||totalTxt.getText().isEmpty()==true||stickTxt.getText().isEmpty()==true||stickNumTxt.getText().isEmpty()==true||powTxt.getText().isEmpty()==true||
						speedTxt.getText().isEmpty()==true||manufacturerTxt.getText().isEmpty()==true||vendorTxt.getText().isEmpty()==true||priceTxt.getText().isEmpty()==true){
					JOptionPane.showMessageDialog(frame, "Invalid or missing information", "Error" ,JOptionPane.ERROR_MESSAGE);
					return;
				}
				else{	
					System.out.println("Adding");
					String quer = "EXECUTE addRAM ?,?,?,?,?,?,?,?,?";
					try {
						CallableStatement c = con.prepareCall(quer);
						c.setString(1, nameTxt.getText());
						c.setInt(2, new Integer(totalTxt.getText()));
						c.setInt(3, new Integer(stickTxt.getText()));
						c.setInt(4, new Integer(stickNumTxt.getText()));
						c.setInt(5, new Integer(speedTxt.getText()));
						c.setInt(6, new Integer(powTxt.getText()));
						c.setString(7,  manufacturerTxt.getText());
						c.setString(8, vendorTxt.getText());
						c.setInt(9, new Integer(priceTxt.getText()));
						System.out.println("Added");
						frame.dispose();
						
						} catch (Exception e) {
						JOptionPane.showMessageDialog(frame, "Part not Added", "Error" ,JOptionPane.ERROR_MESSAGE);
					}
				}	    
			}
	    	});
		
		
		frame.setLayout(new GridLayout(row,col,2,3));
		
		frame.add(new JLabel("Name"));
		frame.add(new JLabel("Total GB"));
		frame.add(new JLabel("Stick GB"));
		frame.add(new JLabel("Sticks"));
		frame.add(new JLabel("Speed MHz"));
		frame.add(new JLabel("Manufacturer"));
		frame.add(new JLabel("Vendor"));
		frame.add(new JLabel("Price"));
		frame.add(exitBut);
		
		frame.add(nameTxt);
		frame.add(totalTxt);
		frame.add(stickTxt);
		frame.add(stickNumTxt);
		frame.add(speedTxt);
		frame.add(manufacturerTxt);
		frame.add(vendorTxt);
		frame.add(priceTxt);
		frame.add(addBut);
						
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(((int)screenSize.getWidth()/2)-(loginW/2), ((int)screenSize.getHeight()/2)-(loginH/2), loginW, loginH);
		frame.setResizable(false);
		frame.setVisible(true); 
	}
}