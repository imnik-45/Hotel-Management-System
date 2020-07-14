package Pack1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class Roomwrite
{
	@SuppressWarnings("unchecked")
	public static ArrayList<room_info> readObjectFromFile()
	{
		ArrayList<room_info> userlistfromfile;
		try
		{
		   FileInputStream fin=new FileInputStream("room.txt");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   userlistfromfile=(ArrayList<room_info>)oin.readObject();
		   
		   oin.close();
		   fin.close();
		}catch(Exception e)
		 {
			userlistfromfile=new ArrayList<room_info>();
		 }
		 
		return userlistfromfile;
	}
	
	public static void writeObjecttoFile(ArrayList<room_info> ulist)
	{
		try	
		 {
		       FileOutputStream fout=new FileOutputStream("room.txt");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(ulist);
		       
		       oout.close();
		}catch(Exception e){System.out.println(e);}
	}
}