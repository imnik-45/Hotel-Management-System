package Pack1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SearchDisp extends JFrame 
{
	private static final long serialVersionUID = 1L;

	public SearchDisp(int index)
	{
		super("Search Window");
		String heading[]={"ID","Name","Age","Email Id","MobNo","Address","Gender"
				,"Cindate","Coutdate"};
		String data[][] = new String[12][12];
		ArrayList<Guest_Info> emplist;
		ArrayList<new_info> blist;
		Font f=new Font("Lucida Sans",Font.BOLD,25);
		JTable datatable=new JTable();
		DefaultTableModel model=new DefaultTableModel();
		try
		{
			emplist= UserInfoReadWriteFromFile.readObjectFromFile();
			blist=UserCheckInData.readObjectFromFile();
					
			Guest_Info re = emplist.get(index);
			new_info rx=blist.get(index);
			
			int r = 0;
		
		    data[r][0]=re.getId();
			data[r][1]=re.getName();
			data[r][2]=re.getAge();
			data[r][3]=re.getEmailid();
			data[r][4]=re.getMobno();
			data[r][5]=re.getAddress();
			data[r][6]=re.getGender();
			data[r][7]=rx.getChkin();
			data[r][8]=rx.getChkout();
			
			
			
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
		
			setSize(850, 300);
			setLocation(200, 200);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setVisible(true);
				
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(this,"No Booking from this id");
		}
		
	}
}

