import java.io.BufferedWriter;
import java.io.IOException;

public class PrimMST {
	int numNodes;
	int[] inWhichSet;
	int numSets;
	int totalMSTCost;

	undirectedEdge MSTofG= new undirectedEdge();
	undirectedEdge edgeListHead= new undirectedEdge();
	
	PrimMST(int size){
		inWhichSet= new int[size];
		int v=size-1;
		numNodes=v;
		for(int i=1;i<size;i++){
			inWhichSet[i]=0;
		}
		
	}
	
	void insertEdge(undirectedEdge edge, undirectedEdge edgeHead){
		undirectedEdge walker=edgeHead;
		while(walker.next!=null && edge.edgeCost>walker.next.edgeCost){
			walker=walker.next;
		}
		if(walker.next==null){
			walker.next=edge;
			edge.next=null;
		}
		else{
			edge.next=walker.next;
			walker.next=edge;
		}
		
	}
	
	void printList(undirectedEdge edgeListHead,BufferedWriter outFile2) throws IOException{

		
		outFile2.write("ListHead-->");
		

		outFile2.write("("+edgeListHead.Ni+" , "+edgeListHead.Nj+" , "+edgeListHead.edgeCost+")-->");

		while(edgeListHead.next!=null){
			
			outFile2.write("("+edgeListHead.next.Ni+" , "+edgeListHead.next.Nj+" , "+edgeListHead.next.edgeCost+")-->");
			edgeListHead=edgeListHead.next;
		}
		if(edgeListHead.next==null){
			outFile2.write("NULL\n");
		}
		outFile2.write("\n");

	}
	
	undirectedEdge removedEdge(undirectedEdge listHead){
		undirectedEdge removedEdge= listHead;
		undirectedEdge walker=listHead;
		
		if(checkSetAstart()==0){
			inWhichSet[walker.next.Ni]=1;
			
		}

		while(walker.next!=null){	
			if((inWhichSet[walker.next.Ni]==1&&inWhichSet[walker.next.Nj]==1)){
				
				walker=walker.next;
			}		
			else if(inWhichSet[walker.next.Ni]==1||inWhichSet[walker.next.Nj]==1){
				removedEdge=walker.next;
				walker.next=walker.next.next;
				break;
			}
			
			walker=walker.next;
		}


		return removedEdge;
	}


	
	void pushEdge(undirectedEdge nextEdge, undirectedEdge MSTofG){
		undirectedEdge walker=MSTofG;
		while(walker.next!=null){
			walker=walker.next;
		}
		walker.next=nextEdge;
		nextEdge.next=null;
	}

	
	void move2SetA(int Ni, int Nj){

		if(inWhichSet[Ni]==1){
			inWhichSet[Nj]=1;}
		else{
			inWhichSet[Ni]=1;
		}

	}
	
	void checkList(int changeVinSet,int inSet){
		for(int i=0;i<=numNodes;i++){
			if(inWhichSet[i]==inSet){
				inWhichSet[i]=changeVinSet;
			}
		}
	}
	void printSet(BufferedWriter outFile2) throws IOException{
		outFile2.write("\n");
		
		outFile2.write("inWhichSet is:");		
		for(int i=1;i<=numNodes;i++){
			
			outFile2.write(inWhichSet[i]);
			

		}
	
		outFile2.write("\n");
		
	}
	void printMSTofG(BufferedWriter outFile1) throws IOException{
		outFile1.write("***A Kruskal's MST of the input graph is given below:***\n");
		outFile1.write(numNodes+"\n");
		undirectedEdge walker=MSTofG.next;
		while(walker.next!=null){
			
			outFile1.write(walker.Ni+" "+	walker.Nj+" "+walker.edgeCost+"\n");
			walker=walker.next;
		}
		outFile1.write(walker.Ni+" "+walker.Nj+" "+walker.edgeCost+"\n");
		outFile1.write("*** The total cost of a Kruskal's MST is:"+ totalMSTCost+"\n");
	}
	
	int checkSetA(){
		int v=1;
		for(int i=1;i<=numNodes;i++){
			if(inWhichSet[i]!=1){
				v=0;
			}
		}
		return v;
	}
	
	int checkSetAstart(){
		int v=0;
		for(int i=1;i<=numNodes;i++){
			if(inWhichSet[i]==1){
				v=1;
			}
		}
		return v;
	}
	
	
}
