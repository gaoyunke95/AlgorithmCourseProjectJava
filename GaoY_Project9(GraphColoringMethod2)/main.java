import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main{
	private static  Scanner x;
	private static  FileInputStream fstream;

	public static void main(String[] args) throws IOException{
		BufferedWriter outFile1= new BufferedWriter(new FileWriter(args[1]));
	
		try{
			fstream= new FileInputStream(args[0]);
			x= new Scanner(fstream);
		}
		catch(Exception e){
			System.out.println("no file find");
		}
		
		int numNode=x.nextInt();
		int size=numNode+1;
		
		graphColoring g= new graphColoring(size);
		g.numNode=numNode;
		while(x.hasNext()){
			int a;
			int b;
			a=x.nextInt();
			b=x.nextInt();
			g.loadMatrix(a, b);
			g.countEdge(a,b);
			outFile1.write("there is an edge: <"+a+","+b+"> and an edge: <"+b+","+a+">\n");
		}
		

		outFile1.write("initialMatrix:\n\n");
		g.printMatrix(outFile1);
		g.constructNodeList(g.ListHead);
	
		
		int newColor=0;
		int z=1;
		
		while(g.checkAllcolored()==1){
			
			newColor++;
			Node currentNode=g.ListHead.next;
			
			while(currentNode!=null){
				
				
				if(currentNode.color==0&&g.checkAdjacent(currentNode.id,newColor)==0){
					g.adjacencyMatrix[currentNode.id][currentNode.id]=newColor;
					currentNode.color=newColor;
					
				}
				currentNode=currentNode.next;
			}// while
			
			
		}//while for check color.
		
		
		outFile1.write("\nThe Final Matrix with \nnumber of color used:"+newColor+"\n");
		g.printMatrix(outFile1);
	
	fstream.close();
	x.close();
	outFile1.close();
	}
	

}
