package Pack1;
import Pack1.room_info;


import java.awt.Color;
import java.awt.Font;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;


public class user_login extends JFrame {
	
	private static final long serialVersionUID = 1L;
   private String yolo;
   private String pric;
	private JPanel login;

	private JLabel l3;
	JDateChooser dateChooser_chkin = new JDateChooser();
	JDateChooser dateChooser_chkout = new JDateChooser();
	
	double cost,tcost;
	long checkdiff;
	
	private String ids="";
	
	private ArrayList<new_info> blist=new ArrayList<new_info>();
	new_info rt;

	
	private ArrayList<room_info> rlist=new ArrayList<room_info>();
	room_info rx;
	

	
	
	public user_login(String roomno)
	{

		Font f=new Font("Lucida Sans",Font.BOLD,25);
		
		login = new JPanel();
		login.setLayout(null);
		setSize(450,550);
		login.setBackground(new Color(0,0,0,25));
		login.setBounds(450,250,450,550);

		 l3=new JLabel("Book Your Room ");
	     l3.setBounds(150,0,250,50);
	     l3.setFont(f);
	     l3.setForeground(Color.WHITE);
	     login.add(l3);
		
		JLabel lblCheckInDate = new JLabel("Check In");
		lblCheckInDate.setFont(f);
		lblCheckInDate.setBounds(15, 72, 137, 30);
		login.add(lblCheckInDate);
		
		JLabel lblCheckOutDate = new JLabel("Check Out");
		lblCheckOutDate.setFont(f);
		lblCheckOutDate.setBounds(15, 150, 162, 30);
		login.add(lblCheckOutDate);
		
		JLabel rno= new JLabel("Id");
		rno.setFont(f);
		rno.setBounds(15, 200, 202, 30);
		login.add(rno);
		
		JTextField rn1=new JTextField();
		rn1.setFont(f);
        rn1.setBounds(180,200,100, 25);
        login.add(rn1);

		JButton btnCheckRooms = new JButton("Book");
		btnCheckRooms.setBackground(new Color(134, 121, 121));
		btnCheckRooms.setIcon(null);
		btnCheckRooms.setFont(f);
		btnCheckRooms.setBounds(150,400,150,50);
		login.add(btnCheckRooms);
		
		dateChooser_chkin.setBorder(new LineBorder(new Color(0, 0, 0,50)));
		dateChooser_chkin.setDateFormatString("d,M,yyyy");
		dateChooser_chkin.setFont(f);
		dateChooser_chkin.setBounds(250, 83, 150,30);
		login.add(dateChooser_chkin);
		
		
		dateChooser_chkout.setDateFormatString("d,M,yyyy");
		dateChooser_chkout.setBorder(new LineBorder(new Color(0, 0, 0,50)));
		dateChooser_chkout.setFont(f);
		dateChooser_chkout.setBounds(250, 150, 150, 30);
		login.add(dateChooser_chkout);
	
		
		btnCheckRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
try
{
			
				SimpleDateFormat dFormat=new SimpleDateFormat("YYYY:MM:dd");
				String d1=dFormat.format(dateChooser_chkin.getDate());
			    SimpleDateFormat dFormat1=new SimpleDateFormat("YYYY:MM:dd");
				String d2=dFormat1.format(dateChooser_chkout.getDate());
		
			
				String t[]=new String[3];
				t=d1.split(":");
				final LocalDate chkindate,chkoutdate;
				chkindate=LocalDate.of(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]));
				t=d2.split(":");
				chkoutdate=LocalDate.of(Integer.parseInt(t[0]),Integer.parseInt(t[1]),Integer.parseInt(t[2]));
				
				if(chkindate.compareTo(chkoutdate)<=0)
				{
				long d=ChronoUnit.DAYS.between(chkindate,chkoutdate);
				String g=String.valueOf(d);
				
				
			
			

				
	    	   
				
				rlist = Roomwrite.readObjectFromFile();
	    		//data = new String[rlist.size()][12];
				for(room_info rx : rlist)
	    		{
					yolo=rx.getRno();
					pric=rx.getPrice();
					if(yolo.equalsIgnoreCase(roomno))
					{
						rx.setStatus(true);
						//System.out.println(rx.getRno()+" "+rx.getRcat()+" "+rx.getBno()+" "+rx.getRtype()+" "+rx.getPrice()+" "+rx.isStatus());
						
						Roomwrite.writeObjecttoFile(rlist);
						break;
					}
	    		}
				
           		ids=rn1.getText();
			    double price = bill(pric,g);
				String price2 = String.valueOf(price);
				  
				  rlist=Roomwrite.readObjectFromFile();	  
				  rt=new new_info(d1,d2,price2,roomno,ids);
				  blist = UserCheckInData.readObjectFromFile();
			      blist.add(rt);
			      JOptionPane.showMessageDialog(null,"booked");
			      JOptionPane.showMessageDialog(null,"your bill ="+ price2);
			      UserCheckInData.writeObjecttoFile(blist);
				}
			   else
				{
						
					JOptionPane.showMessageDialog(null,"Invalid dates");
				}
				
				
			}catch(Exception e)
			{
			    e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Empty fields");
			}
			}		});


	
		  
		JLabel bg_img = new JLabel();
		bg_img.setIcon(new ImageIcon(user_login.class.getResource("/img9.jpg")));
		bg_img.setBounds(0, 0, 1200,900);

		add(bg_img);
		bg_img.add(login);

		setSize(1200, 900);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	public double bill(String price,String day)
	{
		
		double  net = 0.0;

	int diff=Integer.parseInt(day);
	double pric=Double.parseDouble(price);   

		if (diff >= 0)
		{
	     net=(pric*0.25)+pric;
		}	
		else
		{
			net=0.0;
		}
		return net;
	}


}
