import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;


public class CPU_CoolerList {
	private static Connection con;
	private ResultSet rs;
	private static String[][] data;
 public CPU_CoolerList(final int buildNum, Connection c) throws SQLException{

		int row = 1;
		int col = 8;
		con = c;
		
		System.out.println(buildNum);
		
		final JFrame frame = new JFrame("CPU Cooler List");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		String quer = "EXECUTE getCPU_Coolers";
		PreparedStatement s;
		s = con.prepareStatement(quer);
		rs = s.executeQuery();
		
		String quer2 = "EXECUTE getCoolerCount";
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
  frame.setLayout(new GridLayout(4,1,2,3));
  
  String[] colNames = {"ID", "Name","Socket", "Pow", "Heignt","Price","Vendor","Manufacturer"};
  //frame.add(exitBut);
  data[0] = colNames;
  int iter=1;
  try {
	while(rs.next()){
	   addRow(frame, buildNum, col, iter, rs);
	   iter++;
	  }
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
  JButton delBut = new JButton("Delete from List");
  delBut.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0){
		DeleteCPUCool.DeleteCPUCool(buildNum, con);
	}
});
  JButton addBut = new JButton("Add To List");
  addBut.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent arg0) {
		AddCPUCool.AddCPUCool(buildNum, con);			}  
});
  
  final JTextField partID =  new JTextField();
  
  JButton addToBuildBut = new JButton("Add To Build");
    addToBuildBut.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent arg0) {
      System.out.println("Adding to build "+buildNum);
      frame.dispose();
      BuildMan.getBuild(buildNum).CPUCool =new Integer(partID.getText());
     }       
   });
    JPanel panel = new JPanel();
    panel.add(partID);
    panel.add(addToBuildBut);
    panel.setLayout(new GridLayout(1,2));
    frame.add(panel);
  ScrollPane pane = new ScrollPane();
  JTable table =new JTable(data, colNames);
 // table.setEnabled(false);
  pane.add(table);
  frame.add(pane);
  frame.add(addBut);
  frame.add(delBut);
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  frame.setBounds(((int)screenSize.getWidth()/2)-(loginW/2), ((int)screenSize.getHeight()/2)-(loginH/2), loginW, loginH);
  frame.setResizable(true);
  frame.setVisible(true); 
 }
 
 private static void addRow(JFrame frame, final int buildNum, int col, int row, ResultSet resultSet2) throws SQLException{
  
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
    //Not needed for week 9
    
      }       
     });
  
  for(int i=1;i<=col-1;i++){
   data[row][i-1] = resultSet2.getString(i);
  }
  
  //frame.add(addBuildBut);
  
 }
 
}