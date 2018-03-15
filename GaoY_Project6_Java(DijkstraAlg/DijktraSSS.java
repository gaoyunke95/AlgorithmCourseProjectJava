import java.io.BufferedWriter;
import java.io.IOException;

public class DijktraSSS {
	int numNodes;
	int sourceNode;
	int minNode;
	int newCost;
	int currentNode;
	int[][]costMatrix;
	int[] fatherAry;
	int[] toDoAry;
	int[] bestCostAry;
	
	DijktraSSS(int index){
		costMatrix= new int [index][index];
		fatherAry= new int[index];
		toDoAry= new int[index];
		bestCostAry= new int[index];
	}
	
	void loadCostMatrix(int x,int y,int c){
        costMatrix[x][y]=c;
    }
    void setBestCostAry(int x){
       
        for(int i=0;i<=numNodes;i++){
            bestCostAry[i]=costMatrix[x][i];
        }
    }
    
    void setFatherAry(int x){
       
        for(int i=1; i<=numNodes;i++)
            fatherAry[i]=x;
    }
    
    void setToDoAry(int x){
        
    	for(int i=0;i<=numNodes;i++){
            toDoAry[i]=1;
            if(i==sourceNode||i==0){
                toDoAry[i]=0;
            }
        }
    }
    
    int findMinNode(){
        int temp=9999;
        int minNode=0;
        for(int i=0;i<=numNodes;i++){
            
            if(toDoAry[i]==1&&bestCostAry[i]<temp){
                temp=bestCostAry[i];
                minNode=i;
            }
        }
        return minNode;
    }
    
    void markMinNode(int x){
        toDoAry[x]=0;
    }
    int checkToDoAry(){
        int v=0;
        for(int i=0;i<numNodes;i++){
        	
        	if(toDoAry[i]==1){
                v=1;
                return v;
            }
        }
        
        return v;
        
    }
    int computeCost(int x, int y){
        int cost;
        cost= bestCostAry[x]+costMatrix[x][y];
        return cost;
    }
    
    void changeCost(int x, int y){
        bestCostAry[x]= y;
        
    }
    
    void changeFather(int x, int y){
        fatherAry[x]=y;
    }
    
    void debugPrint(BufferedWriter outFile2) throws IOException
    {
    	outFile2.write( "The soruceNode is: " + sourceNode+"\n");
        outFile2.write("The fatherAry is: ");
        for(int i=1; i<=numNodes; i++){
            
        	outFile2.write(fatherAry[i]+ " ");
        }
        
        outFile2.write("\n");
        outFile2.write("The bestCostAry is: ");
        for(int i=1; i<=numNodes; i++){
        	outFile2.write(bestCostAry[i] +" ");
        }
        
        outFile2.write("\n");
        outFile2.write( "The toDoAry is: ");
        for(int i=1; i<=numNodes; i++){
        	outFile2.write(toDoAry[i] + " ");
            
        }
        outFile2.write("\n\n");
  
    }
    
    void printShortestPath(int x,BufferedWriter outFile1) throws IOException{

    	if(x==sourceNode){
    		outFile1.write(sourceNode+"<- "+sourceNode+" :cost= "+ bestCostAry[x]+"\n");
    	}
    	else{
    		printFather(x, outFile1);
    		outFile1.write(bestCostAry[x]+"\n");
 
    	}
        
    }
    
    void printFather(int index,BufferedWriter outFile1) throws IOException{
        if(index==sourceNode){
        	outFile1.write(sourceNode+" :cost = ");
        }
        else{
        	outFile1.write(index+ "<- ");
            printFather(fatherAry[index],outFile1);
        }
    }

}
