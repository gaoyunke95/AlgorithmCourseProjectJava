import java.io.*;
import java.util.Scanner;
		
public class project1 {
		private static  Scanner x;
		private static  FileInputStream fstream;
		private static  String input;
		static LinkedList link= new LinkedList();
	public static void main(String[] args) throws IOException{
		
		
		 try{
			 fstream= new FileInputStream(args[0]);
			 x= new Scanner(fstream);
		 }
		 catch(Exception e){
			 System.out.println("no file find");
		 }
		 int size=0;
		 BufferedWriter writer= new BufferedWriter(new FileWriter(args[1],true));
		 while(x.hasNext()&&size<=15){
			 writer.write(link.printList()); 
			 input=x.next();
			 link.listInsert(input);
			 size++;
		 }
		 
			 
		 x.close();
		 fstream.close();
		 writer.close();
	}
	
}
