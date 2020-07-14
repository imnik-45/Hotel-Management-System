package Pack1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class disproom extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	disproom()
	{
	super("Display All");
	
	Font f=new Font("Lucida Sans",Font.BOLD,25);
	String heading[]={"Rno","Rcat","bed no","type","price","Status"};
	String data[][];
	ArrayList<room_info> list;
	try
	{
		list = Roomwrite.readObjectFromFile();
		
		data = new String[list.size()][12];
		
		int r=0;
		for(room_info ra : list)
		{
			data[r][0]=ra.getRno();
			data[r][1]=ra.getRcat();
			data[r][2]=ra.getBno();
			data[r][3]=ra.getRtype();
			data[r][4]=ra.getPrice();
			data[r][5]=Boolean.toString(ra.isStatus());
		
		
	//		System.out.println(data[r][0]+" "+data[r][1]+" "+data[r][2]+" "+data[r][3]+" "+data[r][4]+" "+data[r][5]);
			r++;
		}
		
		Container con=getContentPane();
		con.setLayout(new BorderLayout());
		
		JTable datatable=new JTable(data, heading);
		datatable.setRowHeight(50);
		
		datatable.setFont(f);
		JScrollPane jsp=new JScrollPane(datatable);
		
		con.add(new JLabel("All Registration Details"),BorderLayout.NORTH);
		con.add(jsp,BorderLayout.CENTER);
		
		setSize(850, 300);
		setLocation(200, 200);
		setVisible(true);
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	}
}


