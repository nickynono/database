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


public class AddGPU {

	public static void AddGPU(int buildNum, final Connection con){
		
		int row = 2;
		int col = 17;
		
		int loginW = col*100;
		int loginH = row*40;
		
		System.out.println("Add GPU");
		
		final JFrame frame = new JFrame("Add GPU");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		final JTextField nameTxt =  new JTextField();
		final JTextField memoryTxt =  new JTextField();
		final JTextField PCITxt =  new JTextField();
		final JTextField PCIeTxt =  new JTextField();
		final JTextField PCIx16Txt =  new JTextField();
		final JTextField HDMITxt =  new JTextField();
		final JTextField DVITxt =  new JTextField();
		final JTextField VGATxt =  new JTextField();
		final JTextField DisplayPortTxt =  new JTextField();
		final JTextField MiniDisplayPortTxt =  new JTextField();
		final JTextField SLICrossfireTxt =  new JTextField();
		final JTextField LengthTxt =  new JTextField();
		final JTextField powerTxt =  new JTextField();
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
			private CallableStatement CallableStatement;

			public void actionPerformed(ActionEvent arg0) {
		
				if(nameTxt.getText().isEmpty()==true||memoryTxt.getText().isEmpty()==true||PCITxt.getText().isEmpty()==true||PCIeTxt.getText().isEmpty()==true||PCIx16Txt.getText().isEmpty()==true||
					PCITxt.getText().isEmpty()==true||HDMITxt.getText().isEmpty()==true||DVITxt.getText().isEmpty()==true||VGATxt.getText().isEmpty()==true||DisplayPortTxt.getText().isEmpty()==true||
					MiniDisplayPortTxt.getText().isEmpty()==true||SLICrossfireTxt.getText().isEmpty()==true||powerTxt.getText().isEmpty()==true||manufacturerTxt.getText().isEmpty()==true||vendorTxt.getText().isEmpty()==true||
					priceTxt.getText().isEmpty()==true){
					JOptionPane.showMessageDialog(frame, "Invalid or missing information", "Error" ,JOptionPane.ERROR_MESSAGE);
					return;
				}
				else{	
					String quer = "EXECUTE addGPU ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
					try {
						CallableStatement c = con.prepareCall(quer);
						c.setString(1, nameTxt.getText());
						c.setInt(2, new Integer(memoryTxt.getText()));
						c.setInt(3, new Integer(PCITxt.getText()));
						c.setInt(4, new Integer(PCIeTxt.getText()));
						c.setInt(5, new Integer(PCIx16Txt.getText()));
						c.setInt(6, new Integer(HDMITxt.getText()));
						c.setInt(7, new Integer(DVITxt.getText()));
						c.setInt(8, new Integer(VGATxt.getText()));
						c.setInt(9, new Integer(DisplayPortTxt.getText()));
						c.setInt(10, new Integer(MiniDisplayPortTxt.getText()));
						c.setString(11, SLICrossfireTxt.getText());
						c.setInt(12, new Integer(LengthTxt.getText()));
						c.setInt(13, new Integer(powerTxt.getText()));
						c.setString(14, manufacturerTxt.getText());
						c.setString(15, vendorTxt.getText());
						c.setInt(16, new Integer(priceTxt.getText()));
						c.execute();
						frame.dispose();
					} catch (SQLException|NumberFormatException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(frame, "Part not Added", "Error" ,JOptionPane.ERROR_MESSAGE);
					}
					
					
						
				}	    
			}
	    	});
		
		
		frame.setLayout(new GridLayout(row,col,2,3));
		
		frame.add(new JLabel("Name"));
		frame.add(new JLabel("Memory GB"));
		frame.add(new JLabel("PCI Slot"));
		frame.add(new JLabel("PCIe Slot"));
		frame.add(new JLabel("PCIx16 Slot"));
		frame.add(new JLabel("HDMI Ports"));
		frame.add(new JLabel("DVI Ports"));
		frame.add(new JLabel("VGA Ports"));
		frame.add(new JLabel("DisplayPort"));
		frame.add(new JLabel("MiniDisplayPort"));
		frame.add(new JLabel("SLI/Crossfire"));
		frame.add(new JLabel("Length"));
		frame.add(new JLabel("Power Usage"));
		frame.add(new JLabel("Manufacturer"));
		frame.add(new JLabel("Vendor"));
		frame.add(new JLabel("Price"));
		frame.add(exitBut);
		
		frame.add(nameTxt);
		frame.add(memoryTxt);
		frame.add(PCITxt);
		frame.add(PCIeTxt);
		frame.add(PCIx16Txt);
		frame.add(HDMITxt);
		frame.add(DVITxt);
		frame.add(VGATxt);
		frame.add(DisplayPortTxt);
		frame.add(MiniDisplayPortTxt);
		frame.add(SLICrossfireTxt);
		frame.add(LengthTxt);
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