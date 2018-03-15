import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class main {

	public static int[] charCount= new int[256];	

	public static void main(String[] args) throws IOException{
		BufferedWriter writer= new BufferedWriter(new FileWriter(args[1]));
		FileReader x=null;
		try{
			x= new FileReader(args[0]);
		}
		catch(Exception e){
			System.out.println("no file find");
		}
		
		int a;
		while((a=x.read())!=-1){
			int index= (int) a;	

			if(index>256||index<0){
				index=x.read();
			}
			charCount[index]++;
			if(index==9||index==10||index==13||index==32){
				charCount[index]=0;
			}
		}
		writer.write(printAry());
		
		writer.close();
		x.close();
	}

	
	public static String printAry(){
		int index=0;
		String output="";
		
		while(index<256){
			if(charCount[index]>0){
				char input = (char) index;
				output+=input+" :"+charCount[index];
				output+=System.lineSeparator();

			}
			index++;
		}
		return output;
	}
	
}
