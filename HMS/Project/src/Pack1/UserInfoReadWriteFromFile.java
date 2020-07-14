package Pack1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class UserInfoReadWriteFromFile 
{
	@SuppressWarnings("unchecked")
	public static ArrayList<Guest_Info> readObjectFromFile()
	{
		ArrayList<Guest_Info> userlistfromfile;
		try
		{
		   FileInputStream fin=new FileInputStream("database.txt");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   userlistfromfile=(ArrayList<Guest_Info>)oin.readObject();
		   
		   oin.close();
		   fin.close();
		}catch(Exception e)
		 {
			userlistfromfile=new ArrayList<Guest_Info>();
		 }
		 
		return userlistfromfile;
	}
	
	public static void writeObjecttoFile(ArrayList<Guest_Info> ulist)
	{
		try	
		 {
		       FileOutputStream fout=new FileOutputStream("database.txt");
		       ObjectOutputStream oout=new ObjectOutputStream(fout);
		       oout.writeObject(ulist);
		       
		       oout.close();
		}catch(Exception e){System.out.println(e);}
	}
}