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


public class AddMobo {
	
	final static JTextField nameTxt =  new JTextField();
	final static JTextField socketTxt =  new JTextField();
	final static JTextField RAMTxt =  new JTextField();
	final static JTextField PCITxt =  new JTextField();
	final static JTextField PCIeTxt =  new JTextField();
	final static JTextField PCIx16Txt =  new JTextField();
	final static JTextField SATATxt =  new JTextField();
	final static JTextField USB3SlotsTxt =  new JTextField();
	final static JTextField USB2SlotsTxt =  new JTextField();
	final static JTextField USB3PortsTxt =  new JTextField();
	final static JTextField USB2PortsTxt =  new JTextField();
	final static JTextField fanSlotsTxt =  new JTextField();
	final static JTextField powerTxt =  new JTextField();
	final static JTextField manufacturerTxt =  new JTextField();
	final static JTextField vendorTxt =  new JTextField();
	final static JTextField priceTxt =  new JTextField();

	public static void AddMobo(int buildNum, final Connection con){
		
		int row = 2;
		int col = 17;
		
		int loginW = col*100;
		int loginH = row*40;
		
		System.out.println("Add Motherboard");
		
		final JFrame frame = new JFrame("Add Motherboard");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		JButton exitBut = new JButton("Exit");
		exitBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();	    	}       
	    });
		
		
		JButton addBut = new JButton("Add");
		addBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
		
				if(nameTxt.getText().isEmpty()==true||socketTxt.getText().isEmpty()==true||RAMTxt.getText().isEmpty()==true||PCITxt.getText().isEmpty()==true||PCIeTxt.getText().isEmpty()==true||
					PCIx16Txt.getText().isEmpty()==true||SATATxt.getText().isEmpty()==true||USB3SlotsTxt.getText().isEmpty()==true||USB2SlotsTxt.getText().isEmpty()==true||USB3PortsTxt.getText().isEmpty()==true||
					USB2PortsTxt.getText().isEmpty()==true||fanSlotsTxt.getText().isEmpty()==true||powerTxt.getText().isEmpty()==true||manufacturerTxt.getText().isEmpty()==true||vendorTxt.getText().isEmpty()==true||
					priceTxt.getText().isEmpty()==true){
					JOptionPane.showMessageDialog(frame, "Invalid or missing information", "Error" ,JOptionPane.ERROR_MESSAGE);
					return;
				}
					try {
						CallableStatement c = con.prepareCall("EXEC addMOBO ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
						c.setString(1, nameTxt.getText());
						c.setString(2, socketTxt.getText());
						c.setInt(3, new Integer((RAMTxt.getText())));
						c.setInt(4, new Integer (PCITxt.getText()));
						c.setInt(5,  new Integer(PCIeTxt.getText()));
						c.setInt(6, new Integer (PCIx16Txt.getText()));
						c.setInt(7, new Integer (SATATxt.getText()));
						c.setInt(8, new Integer (USB3SlotsTxt.getText()));
						c.setInt(9, new Integer (USB2SlotsTxt.getText()));
						c.setInt(10, new Integer (USB3PortsTxt.getText()));
						c.setInt(11, new Integer (USB2PortsTxt.getText()));
						c.setInt(13, new Integer (fanSlotsTxt.getText()));
						c.setInt(14, new Integer (powerTxt.getText()));
						c.setString(12, manufacturerTxt.getText());
						c.setString(15, vendorTxt.getText());
						c.setInt(16, new Integer (priceTxt.getText()));
						c.execute();
						
						System.out.println("Added");
						frame.dispose();
					} catch (SQLException | NumberFormatException e) {
						JOptionPane.showMessageDialog(frame, "Part not Added", "Error" ,JOptionPane.ERROR_MESSAGE);
					}
				
				}
	    	});
		
		
		frame.setLayout(new GridLayout(row,col,2,3));
		
		frame.add(new JLabel("Name"));
		frame.add(new JLabel("Socket"));
		frame.add(new JLabel("RAM Slots"));
		frame.add(new JLabel("PCI Slots"));
		frame.add(new JLabel("PCIe Slots"));
		frame.add(new JLabel("PCIx16 Slots"));
		frame.add(new JLabel("SATA Slots"));
		frame.add(new JLabel("USB 3.0 Slots"));
		frame.add(new JLabel("USB 2.0 Slots"));
		frame.add(new JLabel("USB 3.0 Ports"));
		frame.add(new JLabel("USB 2.0 Ports"));
		frame.add(new JLabel("Fan Slots"));
		frame.add(new JLabel("Power Usage"));
		frame.add(new JLabel("Manufacturer"));
		frame.add(new JLabel("Vendor"));
		frame.add(new JLabel("Price"));
		frame.add(exitBut);
		
		frame.add(nameTxt);
		frame.add(socketTxt);
		frame.add(RAMTxt);
		frame.add(PCITxt);
		frame.add(PCIeTxt);
		frame.add(PCIx16Txt);
		frame.add(SATATxt);
		frame.add(USB3SlotsTxt);
		frame.add(USB2SlotsTxt);
		frame.add(USB3PortsTxt);
		frame.add(USB2PortsTxt);
		frame.add(fanSlotsTxt);
		frame.add(powerTxt);
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