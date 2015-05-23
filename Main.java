import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.*;

import javax.swing.*;

public class Main {
	private static Connection con;
	public static void main(String[] args) throws ClassNotFoundException {
		
		int loginW = 200;
		int loginH = 125;
		
		final JFrame frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JTextField uName =  new JTextField();
		final JPasswordField uPass =  new JPasswordField();
		uPass.setEchoChar('*');		
		/*
		 try {
		 
			Driver d = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
			String connectionUrl = "jdbc:sqlserver://titan.cs.rose-hulman.edu;database=CustopPC_weiskisl_allennp;";
			con = DriverManager.getConnection(connectionUrl,"333Spring2015Build", "123456");
		
		}
			catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		
		JButton loginBut = new JButton("Login");
		loginBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			    int isValidUsernamePass = 1;
			    String userN = uName.getText();
			    String userP = String.valueOf(uPass.getPassword());
			    /*
			    try {
					CallableStatement c = con.prepareCall("EXEC Check_Auth ?,?");
					c.setString(1, userN);
					c.setString(2, userP);
					ResultSet rs = c.executeQuery();
					if(rs.next()){
						isValidUsernamePass = 1;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				*/
			    if(isValidUsernamePass == 1){
			     MainScreen.mainScreen(userN,userP, 0);
			    }
			    else{
			     JOptionPane.showMessageDialog(frame, "Invalid Username/Password combination. Please try again.", "Error" ,JOptionPane.ERROR_MESSAGE);
			    }
				frame.dispose();
	    	}       
	    });
		
		
		JButton exitBut = new JButton("Exit");
		exitBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	    	}       
	    });
		
		JButton regBut = new JButton("Register");
		regBut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				final JFrame regFrame = new JFrame("Login");
				regFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				

				final JTextField uNameReg =  new JTextField();
				final JTextField uPassReg =  new JTextField();

				JButton regBut2 = new JButton("Register");
				regBut2.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
												
						if(uNameReg.getText().isEmpty()==true || uPassReg.getText().isEmpty()==true){
							JOptionPane.showMessageDialog(frame, "Username or Password not entered.", "Error" ,JOptionPane.ERROR_MESSAGE);
						}
						/*
						  else{							
						 
							try {
								CallableStatement c = con.prepareCall("EXEC RegUser ?,?");
								c.setString(1, uNameReg);
								c.setString(2, uPassReg);
								ResultSet rs = c.executeQuery();
							} catch (SQLException e) {
								e.printStackTrace();
								JOptionPane.showMessageDialog(frame, "Username taken.", "Error" ,JOptionPane.ERROR_MESSAGE);
							}
							System.out.println("Registered");
							regFrame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
						
						}
					*/
			    	}       
			    });
				

				JButton regExitBut = new JButton("Exit");
				regExitBut.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0) {
						regFrame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
			    	}       
			    });
				
				
				
				regFrame.setLayout(new GridLayout(3, 2, 5, 5));
				
				regFrame.add(regBut2);
				regFrame.add(regExitBut);
				regFrame.add(new JLabel("Username"));
				regFrame.add(uNameReg);
				regFrame.add(new JLabel("Password"));
				regFrame.add(uPassReg);
				
				
				Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
				regFrame.setBounds(((int)screenSize.getWidth()/2)-(loginW/2), ((int)screenSize.getHeight()/2)-(loginH/2), loginW, loginH);
				
				regFrame.setResizable(false);
				regFrame.setVisible(true);
				
	    	} 
			
			
		});
		
		frame.setLayout(new GridLayout(4, 2, 3, 3));
		frame.add(loginBut);
		frame.add(exitBut);
		frame.add(new JLabel("Username"));
		frame.add(uName);
		frame.add(new JLabel("Password"));
		frame.add(uPass);
		frame.add(regBut);
		frame.add(new JLabel());
	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds(((int)screenSize.getWidth()/2)-(loginW/2), ((int)screenSize.getHeight()/2)-(loginH/2), loginW, loginH);
		
		frame.setResizable(false);
		frame.setVisible(true);
		
		}
		
	}

