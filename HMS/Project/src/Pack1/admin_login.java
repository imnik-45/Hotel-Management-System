package Pack1;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class admin_login extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	private JPanel login;
	private JLabel l3;
	private JButton addb,updateb,deleteb,displayb,prevb,searchb;
	
	private String chkout="";
	
	private String sysdate;
	
	public admin_login()
	{
		super("Admin  Panel");
		
		Font f=new Font("Lucida Sans",Font.BOLD,25);
		Font f2=new Font("Lucida Sans",Font.BOLD,22);
		
		login = new JPanel();
		login.setLayout(null);
		setSize(450, 500);
		login.setBackground(new Color(0, 0, 0, 50));
		login.setBounds(380, 220, 450, 550);
	
		
		 l3=new JLabel("Hello  Admin");
	     l3.setBounds(150,0,250,50);
	     l3.setFont(f2);
	     l3.setForeground(Color.WHITE);
	     
		addb = new JButton("Add");
		addb.setForeground(Color.black);
		addb.setBackground(new Color(153, 153, 153));
		addb.setFont(f);

		updateb = new JButton("Update");
		updateb.setForeground(Color.black);
		updateb.setBackground(new Color(153, 153, 153));
		updateb.setFont(f);

		displayb = new JButton("Display Logbook");
		displayb.setForeground(Color.black);
		displayb.setBackground(new Color(153, 153, 153));
		displayb.setFont(f);

		deleteb = new JButton("Delete");
		deleteb.setForeground(Color.black);
		deleteb.setBackground(new Color(153, 153, 153));
		deleteb.setFont(f);

		prevb = new JButton("Disp Guest");
		prevb.setForeground(Color.black);
		prevb.setBackground(new Color(153, 153, 153));
		prevb.setFont(f);
		
	    searchb = new JButton("Search");
		searchb.setForeground(Color.black);
		searchb.setBackground(new Color(153, 153, 153));
		searchb.setFont(f);
		
		addb.addActionListener((e) ->
		{
			new Add();
		});
		
		searchb.addActionListener((e) ->
		{
			new Search();
		});
		
		deleteb.addActionListener((e) ->
		{
			new delete();
		});
		
		displayb.addActionListener((e) ->
		{
		  
			new disptable2();
		});
		
		prevb.addActionListener((e) ->
		{
			
			new display();
		});
		
		updateb.addActionListener((e) ->
		{
			String a=" ";
			
			LocalDate today = LocalDate.now();
			int day = today.getDayOfMonth();
	  		int month = today.getMonthValue();
	  		int year = today.getYear();
				
			 // sysdate =year+":"+month+":"+day; 
		    sysdate="2019:07:23";
			String room;
			  ArrayList<new_info>blist;
			  blist=UserCheckInData.readObjectFromFile();
			  for(new_info re:blist)
			  {
				  chkout=re.getChkout();
			  
			  if(sysdate.equals(chkout))
			  { room=re.getIntr();
			  
			  ArrayList<room_info> rlist;
			  rlist=Roomwrite.readObjectFromFile();
			  for(room_info r:rlist)
			  {
				  if(room.equals(r.getRno()))
						  {	  
					  a+=room+" ";
					
							r.setStatus(false);
							boolean chk=r.isStatus();
					  //System.out.println(chk);
					  Roomwrite.writeObjecttoFile(rlist);
					  break;
						  }
			  }
			  }
			  }
			//  System.out.println(a);
			  
		});
		
		
		addb.setBounds(150, 80, 150, 50);
		updateb.setBounds(150, 160, 150, 50);
		deleteb.setBounds(150, 240, 150, 50);
		displayb.setBounds(100, 320, 260, 50);
		searchb.setBounds(150, 400, 150, 50);
	    prevb.setBounds(100,480, 260,50); 
	    
	    
	     login.add(l3);
	     login.add(addb);
	     login.add(updateb);
	     login.add(deleteb);
	     login.add(displayb);
	     login.add(searchb);
	     login.add(prevb);
		
		JLabel bg_img = new JLabel();
		bg_img.setIcon(new ImageIcon(admin_login.class.getResource("/img2.jpg")));
		bg_img.setBounds(0, 0, 1200, 900);

		add(bg_img);
		bg_img.add(login);

		setSize(1200,900);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		   }
}
