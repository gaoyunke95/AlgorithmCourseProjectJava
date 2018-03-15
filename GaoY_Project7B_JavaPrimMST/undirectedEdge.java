
public class undirectedEdge{
	int Ni;
	int Nj;
	int edgeCost;
	undirectedEdge next;

	
	undirectedEdge(){
		Ni=0;
		Nj=0;
		edgeCost=0;
		next=null;
	}
	undirectedEdge(int a, int b, int c){
		Ni=a;
		Nj=b;
		edgeCost=c;
		next=null;
	}
}
