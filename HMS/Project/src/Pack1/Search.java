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

import Pack1.Guest_Info;
import Pack1.UserInfoReadWriteFromFile;

public class Search extends JFrame
{
		private static final long serialVersionUID = 1L;
		private ArrayList<Guest_Info> emplist;
		
		
		private JPanel sign;
		private JLabel l1;
		private JTextField t1;
		private JButton searchb;
	    private int found=-1;
		
		public Search()
		{
			super("Search Here");

			
			
			Font f=new Font("Lucida Sans",Font.BOLD,25);
			Font f2=new Font("Lucida Sans",Font.BOLD,22);
			
			sign = new JPanel();
			sign.setLayout(null);
			setSize(450, 350);
			sign.setBackground(new Color(0, 0, 0, 50));
			sign.setBounds(350, 250, 450, 350);
			
			l1 = new JLabel("Enter User Id");
	        t1=new JTextField();
	        l1.setFont(f2);
	        l1.setForeground(Color.white);
	        l1.setBounds(65, 60,400, 48);
	        t1.setFont(f);
	        t1.setBounds(65, 120, 300,50);
	        
	        searchb=new JButton("search");
	        searchb.setForeground(Color.black);
	        searchb.setBackground(new Color(134, 121, 121));
	        searchb.setFont(f);
	        searchb.setBounds(150,200,150, 50);
	        
		searchb.addActionListener((e) ->
		{
			emplist=UserInfoReadWriteFromFile.readObjectFromFile();
			
			for(int i=0;i<emplist.size();i++)   
			{
				   
				
			if(t1.getText().trim().equals(emplist.get(i).getId()))
				{
					found=i;
					break;
				}
				
			}
			if(found==-1)
			{
				JOptionPane.showMessageDialog(this,"Id is not available or deleted");
				new admin_login();
			}
			else
			{
				new SearchDisp(found);
				
			}
		
		});
		

		sign.add(l1);
		sign.add(t1);
		sign.add(searchb);
	
		JLabel bg_img = new JLabel();
		bg_img.setIcon(new ImageIcon(Search.class.getResource("/img5.jpg")));
		bg_img.setBounds(0, 0, 1200, 900);

		add(bg_img);
		bg_img.add(sign);
        
		setSize(1200,900);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		}
}