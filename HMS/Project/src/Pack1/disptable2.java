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

public class disptable2 extends JFrame
{
		private static final long serialVersionUID = 1L;

		public disptable2()
		{
			
			super("Display Booking");
			JTable datatable=new JTable();
			ArrayList<new_info> blist;
			String heading[]={"Id","Checkin_Dt","Checkin_Out","Room No","Bill Amt"};
			String data[][];
			Font f=new Font("Lucida Sans",Font.BOLD,25);
			DefaultTableModel model=new DefaultTableModel();
			
			try
			{
				blist=UserCheckInData.readObjectFromFile();
				
				data = new String[blist.size()][12];
				
				int r=0;
				for(new_info rq : blist)
				{
					data[r][0]=rq.getRt();
					data[r][1]=rq.getChkin();
					data[r][2]=rq.getChkout();
					data[r][3]=rq.getIntr();
					data[r][4]=rq.getNet();
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

