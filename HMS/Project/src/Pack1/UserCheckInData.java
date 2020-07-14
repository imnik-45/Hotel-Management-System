package Pack1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserCheckInData {
	

		@SuppressWarnings("unchecked")
		public static ArrayList<new_info> readObjectFromFile()
		{
			ArrayList<new_info> listfromfile;
			try
			{
			   FileInputStream fin=new FileInputStream("checkin.txt");
			   ObjectInputStream oin=new ObjectInputStream(fin);
			   listfromfile=(ArrayList<new_info>)oin.readObject();
			   
			   oin.close();
			   fin.close();
			}catch(Exception e)
			 {
				listfromfile=new ArrayList<new_info>();
			 }
			 
			return listfromfile;
		}
		
		public static void writeObjecttoFile(ArrayList<new_info> ulist)
		{
			try	
			 {
			       FileOutputStream fout=new FileOutputStream("checkin.txt");
			       ObjectOutputStream oout=new ObjectOutputStream(fout);
			       oout.writeObject(ulist);
			       
			       oout.close();
			}catch(Exception e){System.out.println(e);}
		}
	
}
