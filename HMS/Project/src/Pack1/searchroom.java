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


public class searchroom extends JFrame
{
	private static final long serialVersionUID = 1L;
    
	int flag = 0;
	String room="";
	String id="";
	private JLabel l1,l2;
	private JPanel login;
	private JTextField t1,t2;
	private JButton b;
	
	
	searchroom()
	{
		super("Search for room");
		
		login = new JPanel();
		login.setLayout(null);
		setSize(450, 500);
		login.setBackground(new Color(0, 0, 0, 50));
		login.setBounds(380, 220, 480, 500);
	
		

		Font f=new Font("Lucida Sans",Font.BOLD,25);
		l1=new JLabel("ac/na");
		l1.setFont(f);
		l1.setForeground(Color.WHITE);
	    l1.setBounds(120,20, 250,50);
	    
	    t1=new JTextField();
	    t1.setFont(f);
	    t1.setBounds(120,75,250,50);
	
	    l2=new JLabel("bed number's");
	    l2.setFont(f);
	    l2.setForeground(Color.WHITE);
	    l2.setBounds(120,155,250,50);
	    
	    t2=new JTextField();
	    t2.setFont(f);
	    t2.setBounds(120,200,250,50);
	    
	    b=new JButton("search");
	    b.setBounds(120,280,250,50);
	  
	   b.setFont(f);
	  JButton  book=new JButton("book");
	  book.setBounds(120,350,250,50);
	 
	  book.setFont(f);
	    
	    b.addActionListener((e) ->
	    {
			try {
				ArrayList<room_info> rlist;
         
                
				rlist = Roomwrite.readObjectFromFile();
				String data[][];
				data = new String[rlist.size()][12];
				
				int r = 0;
				for (room_info re : rlist) {
					data[r][0] = re.getRno();
					data[r][1] = re.getRcat();
					data[r][2] = re.getBno();
					data[r][3] = re.getRtype();
					data[r][4] = re.getPrice();
					data[r][5] = Boolean.toString(re.isStatus());

				 /*	System.out.println(r);
			    	System.out.println(data[r][0] + " " + data[r][1] + " " + data[r][2] + " " + data[r][3] + " "
							+ data[r][4] + " " + data[r][5]);
                */
					int bn = Integer.parseInt(data[r][2]);
					int t2n = Integer.parseInt(t2.getText());
					if (data[r][3].equalsIgnoreCase(t1.getText()) && bn == t2n
							&& data[r][5].equalsIgnoreCase("false")) {
						flag = 1;
						room = data[r][0];
						new disproom();
						break;
					}
					r++;
					
				}
				
				if (flag == 0) {
					JOptionPane.showMessageDialog(this, "room not available");
				}
			} catch (Exception a) {
				JOptionPane.showMessageDialog(this, "please fill the textfields");

			}
	    });
	    book.addActionListener((s) ->
	    {
	    	if(flag==1)
	    	new user_login(room);
	    	else
	    		JOptionPane.showMessageDialog(this,"search the room first ");
	    });
	 
	    
	    
	login.add(l1);
	login.add(t1);
	login.add(l2);
	login.add(t2);
	login.add(b);
	login.add(book);
	
	JLabel bg_img = new JLabel();
	bg_img.setIcon(new ImageIcon(admin_login.class.getResource("/img3.jpg")));
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
