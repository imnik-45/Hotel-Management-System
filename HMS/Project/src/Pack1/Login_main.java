package Pack1;

/*
 Coding done by:- Nikhil Singh, BCET, Dgr. 2200 lines of coding in  java with swing.
 */
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


class login extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private JButton loginb,signupb,clearb;
	private JPanel login;
	private JTextField t1;
	private JLabel l1,l2,l3;
	private JPasswordField p1;
    ArrayList<Guest_Info> emplist = UserInfoReadWriteFromFile.readObjectFromFile();
	Guest_Info obj;
	
	@SuppressWarnings("deprecation")
	login()
	{
		super("Home-Page");
  
		Font f=new Font("Lucida Sans",Font.BOLD,25);
		Font f2=new Font("Lucida Sans",Font.BOLD,22);
		
		login = new JPanel();
		login.setLayout(null);
		setSize(450, 350);
		login.setBackground(new Color(0, 0, 0, 50));
		login.setBounds(350, 250, 500, 450);
	        
	     l3=new JLabel("LOGIN");
	     l3.setBounds(210,0,250,50);
	     l3.setFont(f2);
	     l3.setForeground(Color.WHITE);
        
        l1=new JLabel("Enter the User Id");
        t1=new JTextField();
        l1.setFont(f2);
        l1.setForeground(Color.white);
        l1.setBounds(47, 60,400, 48);
        t1.setFont(f);
        t1.setBounds(50, 100, 400, 50);
         
        
        l2=new JLabel("Enter the Password");
        l2.setFont(f2);
        l2.setForeground(Color.white);
        l2.setBounds(47, 180,400, 48);
        p1=new JPasswordField();
        p1.setFont(f);
        p1.setBounds(50, 220, 400, 50);
         
        
        login.add(l3);
        login.add(l1);
        login.add(t1);
        login.add(l2);
        login.add(p1);
        
    	loginb=new JButton("login");
        loginb.setForeground(Color.black);
        loginb.setBackground(new Color(134, 121, 121));
        loginb.setFont(f);
        
        signupb=new JButton("Signup");
        signupb.setForeground(Color.black);
        signupb.setBackground(new Color(134, 121, 121));
        signupb.setFont(f);
        
        clearb=new JButton("clear");
        clearb.setForeground(Color.black);
        clearb.setBackground(new Color(134, 121, 121));
        clearb.setFont(f);
        
        
		
        loginb.setBounds(50,300,150, 50);
        login.add(loginb);
        signupb.setBounds(300,300,150, 50);
        login.add(signupb);
        clearb.setBounds(175,380, 150, 50);
        
        
        
        loginb.addActionListener((e) ->
		{
			
			boolean isdatavalidate = dataValidation();
			
			if (t1.getText().equalsIgnoreCase("admin") && p1.getText().equalsIgnoreCase("admin"))
			{
			
					JOptionPane.showMessageDialog(this, "welcome Admin");
					new admin_login();
			
			}
			else if (getinfo()) {
				if (isdatavalidate) {
					JOptionPane.showMessageDialog(this, "Welcome User");
					
					//new user_login(t1.getText());
					
					new searchroom();
				}
			} else
				JOptionPane.showMessageDialog(this, "invalid id and password");
			
		});
        
        signupb.addActionListener((e) ->
        {
        	new signup();
        	
        });
        
        clearb.addActionListener((e) ->
        {
        	this.dispose();
        	new login();
        });
        
        login.add(clearb);
        
        JLabel bg_img=new JLabel();
        bg_img.setIcon(new ImageIcon(Login_main.class.getResource("/img.jpg")));
        bg_img.setBounds(0, 0, 1200,900);
        
        add(bg_img);
        bg_img.add(login);
      
		setSize(1200,900);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	

public boolean dataValidation()
 {
	   boolean namevalidation = nameCheck();
	   boolean emailvalidation = emilcheck();
	  
	   
	   if (namevalidation && emailvalidation)
		   return true;
	   
	   return false;
 }

public boolean nameCheck()
{
   boolean namevalid = true;
   String namepattern = "^[a-zA-Z0-9_]*$";
 	
   @SuppressWarnings("resource")
Scanner sc1 = new Scanner(t1.getText().trim());
 	
   String match = sc1.findInLine(namepattern);
 	
   if (match == null)
   {
 	  JOptionPane.showMessageDialog(this, "Invalid Username..Please Enter Valid Username");
 	  t1.setText("");
      namevalid = false;
   }
   return namevalid;
}

public boolean emilcheck()
 {
	boolean emailvalid = true;
 	String emailpattern = "^[a-zA-Z0-9]{5}$";
 	
 	@SuppressWarnings({ "deprecation", "resource" })
	Scanner sc2 = new Scanner(p1.getText().trim());
 	
 	String match1 = sc2.findInLine(emailpattern);
 	
 	if (match1 == null)
 	{
 	   JOptionPane.showMessageDialog(this, "Invalid Password..Please Enter Valid Password");
	   p1.setText("");
	   emailvalid = false;
 	}
 	
 	return emailvalid;
 }
@SuppressWarnings("deprecation")
public boolean getinfo() {
	boolean found = false;
	try
	{
	for (int i = 0; i < emplist.size(); i++) {
		obj = emplist.get(i);
		if (t1.getText().equalsIgnoreCase(emplist.get(i).getId()) && p1.getText().equalsIgnoreCase(emplist.get(i).getPassword())) 
		{

			found = true;
			break;
		}
	}

	
	}
	catch(Exception e)
	{
		JOptionPane.showMessageDialog(this,"wrong");
	}
	if (found)
		return true;
	else
		return false;
}

}

public class Login_main {

	public static void main(String[] args) {
		new login();
	}

}
