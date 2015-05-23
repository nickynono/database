import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MainScreen {
 static int buildNum = 0;
 public static void mainScreen(final String uName, String uPass, final Connection con){
  
  int row = 4;
  int col = 5;
  
  
  int mainW = row*150;
  int mainH = col*75;
  buildNum = 0;
  BuildMan.buildList.add(new buildNumPair(buildNum, new incompleteBuild()));
  
  System.out.println("Main Screen");
  //System.out.println(uName+" "+uPass);
  
  final JFrame frame = new JFrame("Main Screen");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  
  JButton exitBut = new JButton("Exit");
  exitBut.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent arg0) {
    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
      }       
     });
  
	JButton saveBut = new JButton("Save Build");
	  saveBut.addActionListener(new ActionListener(){
	   public void actionPerformed(ActionEvent arg0) {
		   incompleteBuild b = BuildMan.getBuild(buildNum);
		   if(isValid(b)){
	    	String quer = "EXECUTE addBuild ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?";
	    	try {
				CallableStatement c = con.prepareCall(quer);
				c.setString(1, uName);
				c.setString(2, uName);
				c.setInt(3, b.CPU);
				c.setInt(4, b.CPUCool);
				c.setInt(5, b.GPU);
				c.setInt(6, b.mon);
				c.setInt(7, b.Mobo);
				c.setInt(8, b.RAM);
				c.setInt(9, b.storage);
				c.setInt(10, b.Per1);
				c.setInt(11, b.Per2);
				c.setInt(12, b.Per3);
				c.setInt(13, b.Per4);
				c.setInt(14, b.Per5);
				c.setInt(15, b.Per6);
				c.setInt(16, b.Per7);
				c.setInt(17, b.Per8);
				c.setInt(18, b.Per9);
				c.setInt(19, b.Per10);
				c.setInt(20, b.PSU);
				c.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   }
	      }

	      
	     });
  JButton newBut = new JButton("New Build");
  newBut.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent arg0) {
    System.out.println("Create a new build");
    
    
    
    final JFrame newBuildFrame = new JFrame("Login");
    newBuildFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
    final JTextField newBuildName =  new JTextField();
    
    int width = 300;
    int height = 75;

    JButton makeBuildBut = new JButton("Create Build");
    makeBuildBut.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent arg0) {
            
      if(newBuildName.getText().isEmpty()==true){
       JOptionPane.showMessageDialog(frame, "Invalid Name", "Error" ,JOptionPane.ERROR_MESSAGE);
      }
      
      else{
       
       //get largest build number and add 1
       buildNum = BuildMan.getMax() +1;
       newBuildFrame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)); 
       JOptionPane.showMessageDialog(frame, "New build created. The build name is '" +newBuildName.getText()+"'. The build number is " + buildNum, "New Build Created" ,JOptionPane.INFORMATION_MESSAGE);   
      }
        }       
       });
    
    JButton newBuildExitBut = new JButton("Exit");
    newBuildExitBut.addActionListener(new ActionListener(){
     public void actionPerformed(ActionEvent arg0) {
      newBuildFrame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        }       
       });
    
    newBuildFrame.setLayout(new GridLayout(2, 2, 5, 5));
    
    newBuildFrame.add(makeBuildBut);
    newBuildFrame.add(newBuildExitBut);
    newBuildFrame.add(new JLabel("Build Name"));
    newBuildFrame.add(newBuildName);
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    newBuildFrame.setBounds(((int)screenSize.getWidth()/2)-(width/2), ((int)screenSize.getHeight()/2)-(height/2), width, height);
    
    newBuildFrame.setResizable(false);
    newBuildFrame.setVisible(true);

      }       
     });
  
  JButton prevBut = new JButton("Old Builds");
  prevBut.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent arg0) {
    System.out.println("Look at old builds");
    try {
		OldBuildList.OldBuildLst(buildNum, con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      }       
     });
  
  JButton cpuBut = new JButton("CPUs");
  cpuBut.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent arg0) {
    System.out.println("Look at CPUs");
    try {
		CPUList.CPUList(buildNum, con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      }       
     });
  
  JButton moboBut = new JButton("Motherboards");
  moboBut.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent arg0) {
    System.out.println("Look at motherboards");
    try {
		MoboList.MoboList(buildNum, con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      }       
     });
  
  JButton ramBut = new JButton("RAM");
  ramBut.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent arg0) {
    System.out.println("Look at RAM");
    try {
		RAMList.RAMList(buildNum, con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      }       
     });
  
  JButton gpuBut = new JButton("GPUs");
  gpuBut.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent arg0) {
    System.out.println("Look at GPUs");
    try {
		GPUList.GPUList(buildNum, con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      }       
     });
  
  JButton caseBut = new JButton("Cases");
  caseBut.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent arg0) {
    System.out.println("Look at cases");
    try {
		CaseList.CaseList(buildNum, con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      }       
     });
  
  JButton storageBut = new JButton("Storage");
  storageBut.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent arg0) {
    System.out.println("Look at storage");
    try {
		StorageList.StorageList(buildNum, con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      }       
     });
  
  JButton psuBut = new JButton("PSUs");
  psuBut.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent arg0) {
    System.out.println("Look at PSUs");
    try {
		PSUList.PSUList(buildNum,con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      }       
     });
  
  JButton monitorBut = new JButton("Monitors");
  monitorBut.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent arg0) {
    System.out.println("Look at monitors");
    try {
		MonitorList.MonitorList(buildNum,con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      }       
     });
  
  JButton cpuCoolerBut = new JButton("CPU Coolers");
  cpuCoolerBut.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent arg0) {
    System.out.println("Look at CPU coolers");
    try {
		new CPU_CoolerList(buildNum,con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      }       
     });
  
  JButton perripheralBut = new JButton("Peripherals");
  perripheralBut.addActionListener(new ActionListener(){
   public void actionPerformed(ActionEvent arg0) {
    System.out.println("Look at peripherals");
    try {
		PerList.PerList(buildNum, con);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      }       
     });
  JLabel parts = new JLabel("Parts");
  parts.setHorizontalAlignment(0);
  
  frame.setLayout(new GridLayout(row,col,5,5));
  
  frame.add(newBut);
  frame.add(prevBut);
  frame.add(saveBut);
  
  
  for(int i=4;i<=4;i++){
  frame.add(new JLabel());
  }
  
  frame.add(exitBut);
    
  frame.add(parts);
  
  for(int i=12;i<=15;i++){
   frame.add(new JLabel());
  }
  
  frame.add(cpuBut);
  frame.add(cpuCoolerBut);
  frame.add(moboBut);
  frame.add(ramBut);
  frame.add(gpuBut);  
  frame.add(caseBut);
  frame.add(psuBut);
  frame.add(storageBut);
  frame.add(perripheralBut);
  frame.add(monitorBut);
 
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  frame.setBounds(((int)screenSize.getWidth()/2)-(mainW/2), ((int)screenSize.getHeight()/2)-(mainH/2), mainW, mainH);
  
  frame.setResizable(false);
  frame.setVisible(true);
 }

protected static boolean isValid(incompleteBuild b) {
	return b.CPU!=0 && b.CPUCool !=0 && b.cse!=0 && b.GPU!=0 && b.Mobo!=0 && b.mon!=0 && b.Per1!=0 &&b.PSU!=0 &&b.RAM!=0 &&b.storage!=0;
}
}

class BuildNumber{
 
 int buildNumber;
 
 BuildNumber(int bn){
  buildNumber = bn;
 }
 
 public int getBuildNumber(){
  return buildNumber;
 }
 
 public void setBuildNumber(int nBN){
  buildNumber=nBN;
 }
 
}