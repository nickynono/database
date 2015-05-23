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


public class AddCase {

	public static void AddCase(int buildNum, final Connection con){
		
		int row = 2;
		int col = 12;
		
		int loginW = col*100;
		int loginH = row*40;
		
		System.out.println("Add Case");
		
		final JFrame frame = new JFrame("Add Case");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		final JTextField nameTxt =  new JTextField();
		final JTextField formTxt =  new JTextField();
		final JTextField threeTxt =  new JTextField();
		final JTextField twoTxt =  new JTextField();
		final JTextField fiveTxt =  new JTextField();
		final JTextField GPUTxt =  new JTextField();
		final JTextField PSUTxt =  new JTextField();
		final JTextField CPUTxt =  new JTextField();
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
		
				if(nameTxt.getText().isEmpty()==true||formTxt.getText().isEmpty()==true||threeTxt.getText().isEmpty()==true||twoTxt.getText().isEmpty()==true||fiveTxt.getText().isEmpty()==true||
					GPUTxt.getText().isEmpty()==true||PSUTxt.getText().isEmpty()==true||CPUTxt.getText().isEmpty()==true||manufacturerTxt.getText().isEmpty()==true||vendorTxt.getText().isEmpty()==true||
					priceTxt.getText().isEmpty()==true){
					JOptionPane.showMessageDialog(frame, "Invalid or missing information", "Error" ,JOptionPane.ERROR_MESSAGE);
				}
				else{	
					String quer = "EXECUTE addCase ?,?,?,?,?,?,?,?,?,?,?";
					try {
						CallableStatement c = con.prepareCall(quer);
						c.setString(1, nameTxt.getText());
						c.setString(2, formTxt.getText());
						c.setInt(3, new Integer(threeTxt.getText()));
						c.setInt(4, new Integer(twoTxt.getText()));
						c.setInt(5, new Integer(fiveTxt.getText()));
						c.setInt(6, new Integer(GPUTxt.getText()));
						c.setInt(7, new Integer(PSUTxt.getText()));
						c.setInt(8, new Integer(CPUTxt.getText()));
						c.setInt(9, new Integer(manufacturerTxt.getText()));
						c.setInt(10, new Integer(vendorTxt.getText()));
						c.setInt(11, new Integer(priceTxt.getText()));
						c.execute();
						frame.dispose();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(frame, "Part not Added", "Error" ,JOptionPane.ERROR_MESSAGE);
					}
					
					
					
				}	    
			}
	    	});
		
		
		frame.setLayout(new GridLayout(row,col,2,3));
		
		frame.add(new JLabel("Name"));
		frame.add(new JLabel("Form Factor"));
		frame.add(new JLabel("3.5 Bays"));
		frame.add(new JLabel("2.5 Bays"));
		frame.add(new JLabel("5.25 Bays"));
		frame.add(new JLabel("Max GPU Size"));
		frame.add(new JLabel("Max PSU Size"));
		frame.add(new JLabel("Max CPU Cooler"));
		frame.add(new JLabel("Manufacturer"));
		frame.add(new JLabel("Vendor"));
		frame.add(new JLabel("Price"));
		frame.add(exitBut);
		
		frame.add(nameTxt);
		frame.add(formTxt);
		frame.add(threeTxt);
		frame.add(twoTxt);
		frame.add(fiveTxt);
		frame.add(GPUTxt);
		frame.add(PSUTxt);
		frame.add(CPUTxt);
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