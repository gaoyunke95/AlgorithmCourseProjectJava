import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class main {
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
		int sourceNode=s.nextInt();
		int index= numNodes+1;
		
		DijktraSSS	x= new DijktraSSS(index);
		x.sourceNode=sourceNode;
		x.numNodes=numNodes;
		
		for(int i=0;i<index; i++){
			for(int j=0;j<index;j++){
				x.costMatrix[i][j]=9999;
				if(i==j||i==0||j==0){
					x.costMatrix[i][j]=0;
				}
			}
		}

		int y, z,c;
		while(s.hasNext()){
			z=s.nextInt();
			y=s.nextInt();
			c=s.nextInt();
        
			x.loadCostMatrix(z,y,c);
		}
		
		x.setBestCostAry(x.sourceNode);
		x.setFatherAry(x.sourceNode);
		x.setToDoAry(x.sourceNode);

        while(x.checkToDoAry()==1){
			x.minNode=x.findMinNode();
			x.markMinNode(x.minNode);
			x.debugPrint(outFile2);
			
			int currentNode=1;
			while(currentNode<index){
				if(x.toDoAry[currentNode]==1){
					x.newCost=x.computeCost(x.minNode,currentNode);
					if(x.newCost<x.bestCostAry[currentNode]){
						x.changeCost(currentNode, x.newCost);
						x.changeFather(currentNode, x.minNode);
						x.debugPrint(outFile2);
					}
				}
				currentNode++;
			}
			
		}
        outFile1.write("=======================================\n");
        outFile1.write("There are "+x.numNodes+ " nodes in the input graph.\n");
        outFile1.write("=======================================\n");
        outFile1.write("Source node = "+x.sourceNode+"\n");
        outFile1.write("The shortest paths from node "+ x.sourceNode+" are: \n\n");
       
        x.currentNode=1;
        while(x.currentNode<index){
        	outFile1.write("The Path from "+ x.sourceNode+ "to "+x.currentNode+": ");
        	x.printShortestPath(x.currentNode,outFile1);
        	x.currentNode++;
        }
        
        s.close();
        fstream.close();
        outFile1.close();
        outFile2.close();
	}
	
	
}
