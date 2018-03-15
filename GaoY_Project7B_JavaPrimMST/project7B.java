import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class project7B {
	private static  Scanner s;
	private static  FileInputStream fstream;
	
	public static void main(String[] args)throws IOException{
		BufferedWriter outFile1= new BufferedWriter(new FileWriter(args[1]));
		BufferedWriter outFile2= new BufferedWriter(new FileWriter(args[2]));
		try{
			fstream= new FileInputStream(args[0]);
			s= new Scanner(fstream);
		}
		catch(Exception e){
			System.out.println("no file find");
		}
		int numNodes=s.nextInt();
		int size=numNodes+1;
		
		undirectedEdge x= new undirectedEdge();
		PrimMST p= new PrimMST(size);
		
		p.numNodes=numNodes;
		int a,b,c;
		
		while(s.hasNext()){
			a=s.nextInt();
			b=s.nextInt();
			c=s.nextInt();
			
			undirectedEdge newEdge= new undirectedEdge(a,b,c);
			p.insertEdge(newEdge, p.edgeListHead);
			p.printList(p.edgeListHead,outFile2);
		}
		
		
		
		
		
		while(p.checkSetA()!=1){
		
			undirectedEdge nextEdge= p.removedEdge(p.edgeListHead);
			
			p.pushEdge(nextEdge,p.MSTofG);
			p.totalMSTCost+= nextEdge.edgeCost;
			
			p.move2SetA(nextEdge.Ni,nextEdge.Nj);
			
			p.printSet(outFile2);
			p.printList(p.MSTofG,outFile2);
		}
		
		p.printMSTofG(outFile1);
		
		s.close();
		fstream.close();
		outFile1.close();
		outFile2.close();
	}
	
}
