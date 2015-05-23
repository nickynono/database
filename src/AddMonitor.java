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


public class AddMonitor {

	public static void AddMonitor(int buildNum, final Connection con){
		
		int row = 2;
		int col = 16;
		
		int loginW = col*100;
		int loginH = row*40;
		
		System.out.println("Add Monitor");
		
		final JFrame frame = new JFrame("Add Monitor");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		final JTextField nameTxt =  new JTextField();
		final JTextField sizeTxt =  new JTextField();
		final JTextField heightTxt =  new JTextField();
		final JTextField adjTxt =  new JTextField();
		final JTextField vesaTxt =  new JTextField();
		final JTextField speakerTxt =  new JTextField();
		final JTextField hdmiTxt =  new JTextField();
		final JTextField dviTxt =  new JTextField();
		final JTextField vgaTxt =  new JTextField();
		final JTextField dpTxt =  new JTextField();
		final JTextField mdpTxt =  new JTextField();
		final JTextField manufacturerTxt =  new JTextField();
		final JTextField vendorTxt=  new JTextField();
		final JTextField priceTxt=  new JTextField();
		
		
		JButton exitBut = new JButton("Exit");
		exitBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();	    	}       
	    });
		
		
		JButton addBut = new JButton("Add");
		addBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
		
				if(nameTxt.getText().isEmpty()==true||sizeTxt.getText().isEmpty()==true||heightTxt.getText().isEmpty()==true||adjTxt.getText().isEmpty()==true||vesaTxt.getText().isEmpty()==true||
						speakerTxt.getText().isEmpty()==true||hdmiTxt.getText().isEmpty()==true||dviTxt.getText().isEmpty()==true||vgaTxt.getText().isEmpty()==true||dpTxt.getText().isEmpty()==true||
								mdpTxt.getText().isEmpty()==true||manufacturerTxt.getText().isEmpty()==true||vendorTxt.getText().isEmpty()==true||priceTxt.getText().isEmpty()==true){
					JOptionPane.showMessageDialog(frame, "Invalid or missing information", "Error" ,JOptionPane.ERROR_MESSAGE);
					return;
				}
				else{	
					String quer = "EXECUTE addMonitor ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
					try {
						CallableStatement c = con.prepareCall(quer);
						c.setString(1, nameTxt.getText());
						c.setInt(2, new Integer(sizeTxt.getText()));
						c.setInt(3, new Integer(heightTxt.getText()));
						c.setInt(4, new Integer(adjTxt.getText()));
						c.setInt(5, new Integer(vesaTxt.getText()));
						c.setInt(6, new Integer(hdmiTxt.getText()));
						c.setInt(7, new Integer(dviTxt.getText()));
						c.setInt(8, new Integer(vgaTxt.getText()));
						c.setInt(9, new Integer(dpTxt.getText()));
						c.setInt(10, new Integer(mdpTxt.getText()));
						c.setString(11, manufacturerTxt.getText());
						c.setString(12, vendorTxt.getText());
						c.setInt(13, new Integer(priceTxt.getText()));
						c.execute();
						frame.dispose();
					} catch (SQLException|NumberFormatException e) {
						JOptionPane.showMessageDialog(frame, "Part not Added", "Error" ,JOptionPane.ERROR_MESSAGE);
					}
					
				}	    
			}
	    	});
		
		
		frame.setLayout(new GridLayout(row,col,2,3));
		
		frame.add(new JLabel("Name"));
		frame.add(new JLabel("Size"));
		frame.add(new JLabel("Height"));
		frame.add(new JLabel("Adjustable"));
		frame.add(new JLabel("VESA Mount"));
		frame.add(new JLabel("Speaker"));
		frame.add(new JLabel("HDMI Ports"));
		frame.add(new JLabel("DVI Ports"));
		frame.add(new JLabel("VGA Ports"));
		frame.add(new JLabel("DisplayPort"));
		frame.add(new JLabel("MiniDisplayPort"));
		frame.add(new JLabel("Manufacturer"));
		frame.add(new JLabel("Vendor"));
		frame.add(new JLabel("Price"));
		frame.add(exitBut);
		
		frame.add(nameTxt);
		frame.add(sizeTxt);
		frame.add(heightTxt);
		frame.add(adjTxt);
		frame.add(vesaTxt);
		frame.add(speakerTxt);
		frame.add(hdmiTxt);
 		frame.add(dviTxt);
 		frame.add(vgaTxt);
		frame.add(dpTxt);
		frame.add(mdpTxt);
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