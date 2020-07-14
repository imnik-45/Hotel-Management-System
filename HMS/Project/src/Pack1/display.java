package Pack1;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;



public class display extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public display()
	{
		
		super("Display All");
		JTable datatable=new JTable();
		ArrayList<Guest_Info> blist;
		
		String heading[]={"ID","Name","Age","Email Id","Password","MobNo","Address","Gender"};
		String data[][];
		Font f=new Font("Lucida Sans",Font.BOLD,25);
		DefaultTableModel model=new DefaultTableModel();
		
		try
		{
			blist = UserInfoReadWriteFromFile.readObjectFromFile();
		
			data = new String[blist.size()][12];
			
			
			int r=0;
			for(Guest_Info re : blist)
			{
				data[r][0]=re.getId();
				data[r][1]=re.getName();
				data[r][2]=re.getAge();
				data[r][3]=re.getEmailid();
				data[r][4]=re.getPassword();
				data[r][5]=re.getMobno();
				data[r][6]=re.getAddress();
				data[r][7]=re.getGender();
				r++;
			}
			
			
			model.setDataVector(data, heading);
			datatable.setFont(f);
			datatable.setRowHeight(25);
			datatable.setModel(model);
			Container con = getContentPane();
			con.setLayout(new BorderLayout());
			datatable.setBounds(0, 0, 500, 850);
			JScrollPane jsp = new JScrollPane(datatable);

			con.add(new JLabel("All Registration Details"), BorderLayout.NORTH);
			con.add(jsp, BorderLayout.CENTER);

			setSize(850, 500);	
			setLocation(200, 200);
			setVisible(true);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
}