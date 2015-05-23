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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;


public class OldBuildList {
 
 private static Connection con;
private static ResultSet rs;
private static String[][] data;

public static void OldBuildList(int buildNum){
  
  int col = 2;
  int row = 10;
  int builds = 5;
  
  int loginW = col*175;
  int loginH = row*25;
  
  
  System.out.println("Completed Build List");
  
  final JFrame frame = new JFrame("Completed Build Listt");
  frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  
  JButton exitBut = new JButton("Exit");
  exitBut.addActionListener(new ActionListener(){
   private Connection con;

public void actionPerformed(ActionEvent arg0) {
    frame.dispose();
   MainScreen.mainScreen("", "", con); 
   }       
     });
   
  frame.setLayout(new GridLayout(builds+1, 3, 5, 5));
  
  frame.add(new JLabel());
  frame.add(new JLabel());
  frame.add(exitBut);
  
  for(int i=0;i<builds;i++){
   addBuildList(frame,String.valueOf(i), buildNum); 
  }
  
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  frame.setBounds(((int)screenSize.getWidth()/2)-(loginW/2), ((int)screenSize.getHeight()/2)-(loginH/2), loginW, loginH);
  frame.setResizable(false);
  frame.setVisible(true);
 }
 
 public static void addBuildList(final JFrame frame, final String buildName, final int buildNum){
  
  JButton viewBut = new JButton("View Build");
  viewBut.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent arg0) {
    System.out.println("Viewing build "+buildName);
    //open build screen
    frame.dispose();
    CompleteBuild.CompleteBuild(buildNum);
   }       
     });
  
  JButton delBut = new JButton("Delete Build");
  delBut.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent arg0) {
    System.out.println("Deleting build "+buildName);
    frame.dispose();
    OldBuildList.OldBuildList(buildNum);
   }       
     });
  
  frame.add(new JLabel("Build Name Here"));
  frame.add(viewBut);
  frame.add(delBut);
 }

public static void OldBuildLst(final int buildNum, Connection c) throws SQLException {

	int row = 1;
	int col = 22;
	con = c;
	
	System.out.println(buildNum);
	
	final JFrame frame = new JFrame("Build List");
	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
	String quer = "EXECUTE getBuilds";
	PreparedStatement s;
	s = con.prepareStatement(quer);
	rs = s.executeQuery();
	
	String quer2 = "EXECUTE getBuildCount";
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

String[] colNames = {"ID", "Name","CPU", "CPU_Cool", "GPU","Monitor","MOBO","RAM", "Storage", "Peripheral1","Peripheral2"
		,"Peripheral3","Peripheral4","Peripheral5","Peripheral6","Peripheral7","Peripheral7","Peripheral8","Peripheral9","Peripheral10","PSU","Creator"};
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
