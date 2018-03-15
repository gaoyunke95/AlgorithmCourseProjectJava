import java.io.BufferedWriter;
import java.io.IOException;

public class graphColoring {
	int adjacencyMatrix[][];
	int uncolorNode;
	int newColor;
	int numNode;
	int countEdge[];
	Node ListHead= new Node();
	
	int size;
	public graphColoring(int size){
		this.size=size;
		adjacencyMatrix= new int[size][size];
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				adjacencyMatrix[i][j]=0;
			}
		}
		countEdge= new int[size];
		for(int i=0;i<size;i++){
			countEdge[i]=0;
		}
	}
	
	void loadMatrix(int a, int b){
		adjacencyMatrix[a][b]=1;
		adjacencyMatrix[b][a]=1;

	}
	void countEdge(int a, int b){
		countEdge[a]++;
		countEdge[b]++;
	}
	
	void printMatrix(BufferedWriter outFile1) throws IOException{
		for(int i=1;i<size;i++){
			for(int j=1;j<size;j++){
				outFile1.write(adjacencyMatrix[i][j]+" ");
				
			}
			outFile1.write("\n");
		}
	}
	
	void insertNode(Node newNode, Node ListHead){
		Node walker=ListHead;
		while(walker.next!=null&&newNode.numEdges>walker.next.numEdges){	
				walker=walker.next;
		}
		if(walker.next==null){
			walker.next=newNode;
			newNode.next=null;
		}
		else{
			newNode.next=walker.next;
			walker.next=newNode;
		}
	}
	
	void constructNodeList(Node ListHead){
		int i=1;
		while(i<size){
			int numEdges=countEdge[i];
			Node NewNode= new Node(i,numEdges,0);
			insertNode(NewNode,ListHead);	
			i++;	
		}
	}
	
	int checkAdjacent(int id, int color){
		int v=0;
		for(int i=1;i<size;i++){
			if(adjacencyMatrix[id][i]==1){//check the where is the adjacentNode;
				if(adjacencyMatrix[i][i]==color){// check if the adjacentNode is using the color or not;
				v=1;}
			}
			
		}
		return v;
	}
	
	int checkAllcolored(){
		int v=0;
		for (int i=1;i<size;i++){
			if(adjacencyMatrix[i][i]==0){
				
				v=1;
			}
		}
		return v;
	}
	
	
}
