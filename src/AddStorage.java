import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AddStorage {

	public static void AddStorage(int buildNum){
		
		int row = 2;
		int col = 8;
		
		int loginW = col*150;
		int loginH = row*40;
		
		System.out.println("Add Storage");
		
		final JFrame frame = new JFrame("Add Storage");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		final JTextField nameTxt =  new JTextField();
		final JTextField typeTxt =  new JTextField();
		final JTextField sizeTxt =  new JTextField();
		final JTextField threeTxt =  new JTextField();
		final JTextField twoTxt =  new JTextField();
		final JTextField RPMTxt =  new JTextField();
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
		
				if(nameTxt.getText().isEmpty()==true||typeTxt.getText().isEmpty()==true||twoTxt.getText().isEmpty()==true||threeTxt.getText().isEmpty()==true||sizeTxt.getText().isEmpty()==true||
					powTxt.getText().isEmpty()==true||RPMTxt.getText().isEmpty()==true||manufacturerTxt.getText().isEmpty()==true||vendorTxt.getText().isEmpty()==true||priceTxt.getText().isEmpty()==true){
					JOptionPane.showMessageDialog(frame, "Invalid or missing information", "Error" ,JOptionPane.ERROR_MESSAGE);
					return;
				}
				else{	
					System.out.println("Adding");
					boolean added=true;
					
					if(added==true){
						System.out.println("Added");
						frame.dispose();
					}
					else
					JOptionPane.showMessageDialog(frame, "Part not Added", "Error" ,JOptionPane.ERROR_MESSAGE);
				}	    
			}
	    	});
		
		
		frame.setLayout(new GridLayout(row,col,2,3));
		
		frame.add(new JLabel("Name"));
		frame.add(new JLabel("Type"));
		frame.add(new JLabel("Storage GB"));
		frame.add(new JLabel("3.5 Bay"));
		frame.add(new JLabel("2.5 Bay"));
		frame.add(new JLabel("RMP"));
		frame.add(new JLabel("Power"));
		frame.add(new JLabel("Manufacturer"));
		frame.add(new JLabel("Vendor"));
		frame.add(new JLabel("Price"));
		frame.add(exitBut);
		
		frame.add(nameTxt);
		frame.add(typeTxt);
		frame.add(sizeTxt);
		frame.add(threeTxt);
		frame.add(twoTxt);
		frame.add(RPMTxt);
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