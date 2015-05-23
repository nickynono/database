import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class MoboList {

	private static String[][] data;
	static Connection con;
	static ResultSet rs1, rs;

	public static void MoboList(final int buildNum, final Connection c) throws SQLException{
	
		int row = 1;
		int col = 16;
		con = c;
		
		System.out.println("Motherboard List");
		System.out.println(buildNum);
		
		final JFrame frame = new JFrame("Motherboard List");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		String quer = "EXECUTE getMotherboards";
		PreparedStatement s;
		s = con.prepareStatement(quer);
		rs = s.executeQuery();
		
		String quer2 = "EXECUTE getMOBOCount";
		PreparedStatement s2 = con.prepareStatement(quer2);
		ResultSet rs2= s2.executeQuery();
		rs2.next();
		row += rs2.getInt(1);

		data= new String[row][col];

		int loginW = col*100;
		int loginH = 100+ row*25;
		JButton exitBut = new JButton("Exit");
		exitBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();	    	}       
	    });
		
		frame.setLayout(new GridLayout(row+1,col,2,3));
		
		String[] att = {"ID", "Name",
				"Socket","RAM Slots","PCI Slots","PCIe Slots",
				"PCIx16 Slots","SATA Slots","USB 3.0 Slots",
				"USB 2.0 Slots","USB 3.0 Ports","USB 2.0 Ports",
				"Manufacturer","Fan Slots","Price","Vendor"};
		//frame.add(exitBut);
		data[0] = att;
		rs.next();
		
		for(int i=1;i<=row-1;i++){
			try {
				addRow(frame, buildNum,i, col);
				rs.next();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//for(int i=1;i<=col-1;i++){
			//frame.add(new JLabel());
		//}
		JButton delBut = new JButton("Delete from List");
		delBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				DeleteMobo.DeleteMobo(buildNum, con);
			}
		});
		JButton addBut = new JButton("Add To List");
		addBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				AddMobo.AddMobo(buildNum, con);			}  
	    });
		
		final JTextField partID =  new JTextField();
		  
		  JButton addToBuildBut = new JButton("Add To Build");
		    addToBuildBut.addActionListener(new ActionListener(){
		     public void actionPerformed(ActionEvent arg0) {
		      System.out.println("Adding to build "+buildNum);
		      frame.dispose();
		      BuildMan.getBuild(buildNum).Mobo =new Integer(partID.getText());
		     }       
		   });
		    JPanel panel = new JPanel();
		    panel.add(partID);
		    panel.add(addToBuildBut);
		    panel.setLayout(new GridLayout(1,2));

		frame.setLayout(new GridLayout(4,1,2,3));
		ScrollPane sc = new ScrollPane();
		sc.add(new JTable(data, att));
		frame.add(panel);
		frame.add(sc);
		frame.add(addBut);
		frame.add(delBut);
				
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(((int)screenSize.getWidth()/2)-(loginW/2), ((int)screenSize.getHeight()/2)-(loginH/2), loginW, loginH);
		frame.setResizable(true);
		frame.setVisible(true); 
	}
	
	private static void addRow(JFrame frame, final int buildNum, int row, int col) throws SQLException{
		
		String butText;
		
		
		
		if(buildNum==0)
			butText = "New Build";
		else
			butText = "Add to " +buildNum;
		
		JButton addBuildBut = new JButton(butText);
		addBuildBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Added to " +buildNum);
				
				//TODO: add to incomplete build with stored procedure
				
	    	}       
	    });
		
		for(int i=1;i<=col;i++){
			data[row][i-1] = rs.getString(i);
		}
		
		
		//frame.add(addBuildBut);
		
	}
	
}