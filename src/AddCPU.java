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


public class AddCPU {

	public static void AddCPU(int buildNum, final Connection con){
		
		int row = 2;
		int col = 12;
		
		int loginW = col*100;
		int loginH = row*40;
		
		System.out.println("Add CPU");
		
		final JFrame frame = new JFrame("Add CPU");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		final JTextField nameTxt =  new JTextField();
		final JTextField socketTxt =  new JTextField();
		final JTextField coresTxt =  new JTextField();
		final JTextField GHzTxt =  new JTextField();
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
		
				if(nameTxt.getText().isEmpty()==true||socketTxt.getText().isEmpty()==true||coresTxt.getText().isEmpty()==true||GHzTxt.getText().isEmpty()==true||powTxt.getText().isEmpty()==true||
						manufacturerTxt.getText().isEmpty()==true||vendorTxt.getText().isEmpty()==true||priceTxt.getText().isEmpty()==true){
					JOptionPane.showMessageDialog(frame, "Invalid or missing information", "Error" ,JOptionPane.ERROR_MESSAGE);
				}				else{	
					System.out.println("Adding");
					boolean added=true;
					try {
						CallableStatement c = con.prepareCall("EXEC addCPU ?,?,?,?,?,?,?,?");
						c.setString(1,nameTxt.getText());
						c.setString(2, socketTxt.getText());
						c.setInt(3, new Integer(coresTxt.getText()));
						c.setInt(4, new Integer (GHzTxt.getText()));
						c.setInt(5, new Integer(powTxt.getText()));
						c.setString(6,  manufacturerTxt.getText());
						c.setString(7, vendorTxt.getText());
						c.setInt(8, new Integer(priceTxt.getText()));
						c.execute();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(frame, "Part not Added", "Error" ,JOptionPane.ERROR_MESSAGE);
					}

					if(added==true){
						System.out.println("Added");
						frame.dispose();
					}
					else
						System.out.println("Not added");
				}	    
			}
	    	});
		
		
		frame.setLayout(new GridLayout(row,col,2,3));
		
		frame.add(new JLabel("Name"));
		frame.add(new JLabel("Socket"));
		frame.add(new JLabel("Cores"));
		frame.add(new JLabel("GHz Speed"));
		frame.add(new JLabel("Power Usage"));
		frame.add(new JLabel("Manufacturer"));
		frame.add(new JLabel("Vendor"));
		frame.add(new JLabel("Price"));
		frame.add(exitBut);
		
		frame.add(nameTxt);
		frame.add(socketTxt);
		frame.add(coresTxt);
		frame.add(GHzTxt);
		frame.add(powTxt);
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