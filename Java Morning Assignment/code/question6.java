package assignment;
import java.io.*;
import java.util.*;

class Data implements Serializable {
	 UUID serialversionUID = new UUID(100,10);
	 int id;
	 int phoneNumber;
	 String email;
	 String name;
	 
	 
	 public Data(int id, String name,String email, int phoneNumber)
	 {
		 this.id = id;
		 this.name = name;
		 this.phoneNumber = phoneNumber;
		 this.email = email;
	 }
}
public class question6{ 
	 public static void display(Data d){
		 System.out.println("ID Data: " + d.id);
		 System.out.println("Name Data: " + d.name);
		 System.out.println("phoneNumber Data: " + d.phoneNumber);		
		 System.out.println("email Data: " + d.email);		 
	 }
	 public static void main(String []args){
		 Data d1 = new Data(1, "Mohit Gupta","mohit.gupta@accolitedigital.com", 952);
		 try {
			 System.out.println("\nSerializing\n");
			 FileOutputStream file = new FileOutputStream("dataFile.txt");
			 ObjectOutputStream out = new ObjectOutputStream(file);
			 out.writeObject(d1);
			 out.close();
			 file.close();
			 System.out.println("Data before deserialization:\n ");
			 display(d1);
		 }
		 catch (Exception e) {
			 System.out.println("Exception Caught");
		 }
		 d1 = null;
		 try {
			 System.out.println("\nDeserializing\n");
			 FileInputStream file = new FileInputStream("dataFile.txt");
			 ObjectInputStream in = new ObjectInputStream(file);
			 d1 = (Data) in.readObject();
			 in.close();
			 file.close();
			 System.out.println("\n\nData after deserialization:\n ");
			 display(d1);
		 }
		 catch (Exception e) { 
			 System.out.println("Exception Caught");
		 }
	 }
	 
}