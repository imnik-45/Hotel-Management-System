package Pack1;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Add extends JFrame {

		private static final long serialVersionUID = 1L;
		
		private JButton signupb,clearb,dispb;
		private JPanel sign;
		private JTextField t1,t2,t3,t4,t5;
		private JLabel l0,l1,l2,l3,l4,l5;
		
		
		private ArrayList<room_info> rlist=new ArrayList<room_info>();
		room_info rx;
		

		Add()
		{
			super("Add Here");

			Font f=new Font("Lucida Sans",Font.BOLD,25);
			Font f2=new Font("Lucida Sans",Font.BOLD,22);
			
			sign = new JPanel();
			sign.setLayout(null);
			setSize(450, 350);
			sign.setBackground(new Color(0, 0, 0, 50));
			sign.setBounds(350,150, 500, 750);
		        
		     l0=new JLabel("Add Room");
		     l0.setBounds(210,0,250,50);
		     l0.setFont(f2);
		     l0.setForeground(Color.WHITE);
	        
	        l1=new JLabel("Room No:");
	        t1=new JTextField();
	        l1.setFont(f2);
	        l1.setForeground(Color.white);
	        l1.setBounds(47, 45,400, 42);
	        t1.setFont(f);
	        t1.setBounds(50, 86, 400, 45);
	         
	        
	        l2=new JLabel("Ac(ac) Nonac(na):");
	        t2=new JTextField();
	        l2.setFont(f2);
	        l2.setForeground(Color.white);
	        l2.setBounds(47, 145,400, 42);
	        t2.setFont(f);
	        t2.setBounds(50, 186, 400, 45);
	        
	        
	        l3=new JLabel("Bed No :");
	        t3=new JTextField();
	        l3.setFont(f2);
	        l3.setForeground(Color.white);
	        l3.setBounds(47, 245,400, 42);
	        t3.setFont(f);
	        t3.setBounds(50, 286, 400, 45);
	        
	        
	        l4=new JLabel("Room Type(dlx/cmn) :");
	        t4=new JTextField();
	        l4.setFont(f2);
	        l4.setForeground(Color.white);
	        l4.setBounds(47, 345,400, 42);
	        t4.setFont(f);
	        t4.setBounds(50, 386, 400, 45);
	        
	        
	        l5=new JLabel("Price :");
	        t5=new JTextField();
	        l5.setFont(f2);
	        l5.setForeground(Color.white);
	        l5.setBounds(47, 445,400, 42);
	        t5.setFont(f);
	        t5.setBounds(50, 486, 400, 45);
			
	        sign.add(l0);
	        sign.add(l1);
	        sign.add(t1);
	        sign.add(l2);
	        sign.add(t2);
	        sign.add(l3);
	        sign.add(t3);
	        sign.add(l4);
	        sign.add(t4);
	        sign.add(l5);
	        sign.add(t5);
	        
	        
	        signupb=new JButton("Add");
	        signupb.setForeground(Color.black);
	        signupb.setBackground(new Color(134, 121, 121));
	        signupb.setFont(f);
	        
	        clearb=new JButton("Reset");
	        clearb.setForeground(Color.black);
	        clearb.setBackground(new Color(134, 121, 121));
	        clearb.setFont(f);
	   
	        
	        dispb=new JButton("Display");
	        dispb.setForeground(Color.black);
	        dispb.setBackground(new Color(134, 121, 121));
	        dispb.setFont(f);
	        
	        signupb.setBounds(165,550,150, 50);
	        sign.add(signupb);
	        clearb.setBounds(165,600,150, 50);
	        sign.add(clearb);
	        dispb.setBounds(165,650,150, 50);
	        sign.add(dispb);
	        
	        signupb.addActionListener((e)->
	        {
	        	
	        	add();
	        	
	        });
	        
	        clearb.addActionListener((e)->
	        {
	        	this.dispose();
	           new Add();
	        });
	        dispb.addActionListener((e)->
	        {
	         new disproom();
	      
	        });
	      
			
	        JLabel bg_img=new JLabel();
	        bg_img.setIcon(new ImageIcon(signup.class.getResource("/img7.jpg")));
	        bg_img.setBounds(0, 0, 1200,900);
	        
	        
	        add(bg_img);
	        bg_img.add(sign);
	        
			setSize(1200,900);
			setLayout(null);
			setLocationRelativeTo(null);
			setResizable(false);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setVisible(true);
		}
		
		public void add()
		{

			try
			{
			        String Rno,Rtype,Bno,Rcat,price;
					boolean status=false;
				if(t1.getText().equals("")||t2.getText().equals("")||t3.getText().equals("")||t4.getText().equals("")||t5.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"empty fields");	
				}
				else
				{
					Rno=t1.getText();
					Rtype=t2.getText();
					Bno=t3.getText();
				    Rcat=t4.getText();
				    price=t5.getText();
			rx = new room_info(Rno, Rtype, Bno, Rcat, price, status);
			rlist = Roomwrite.readObjectFromFile();
			rlist.add(rx);
			Roomwrite.writeObjecttoFile(rlist);
			JOptionPane.showMessageDialog(this, "Added");
				}
			}catch(Exception e)
			{
			 JOptionPane.showMessageDialog(null,"empty fields");
			}
			
			  }
		}
	