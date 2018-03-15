
public class Node {
	int id;
	int color;
	int numEdges;
	Node next;
	
	public Node(){
		id=0;
		color=0;
		numEdges=0;
		next=null;
	}
	public Node(int i,int numE,int c){
		id=i;
		color=c;
		numEdges=numE;
		next=null;
	}
}
