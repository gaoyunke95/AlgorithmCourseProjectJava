import java.io.BufferedWriter;
import java.io.IOException;

public class listBinTreeNode {
	String chStr;
	int prob;
	String code;
	listBinTreeNode next;
	listBinTreeNode left;
	listBinTreeNode right;
	
	public listBinTreeNode(){
		chStr="dummy";
		prob=0;
		code="";
		next=null;
		left=null;
		right=null;
		
	}
	public listBinTreeNode(String data, int p){
		chStr=data;
		prob=p;
		code="";
		next=null;
		left=null;
		right=null;
	}
	public void printNode(listBinTreeNode newNode, BufferedWriter outFile5) throws IOException{
		
		outFile5.write("\n");
		outFile5.write("newNode is:"+ newNode.chStr+"\n");
		outFile5.write("the prob of newNode is:"+newNode.prob+"\n");
		if(newNode.next!=null){
			outFile5.write("the next Node is:"+newNode.next.chStr+"\n");
		}
		if(newNode.next==null){
			outFile5.write("the newNode doesn not have next Node"+"\n");
		}
		if(newNode.left!=null){
			outFile5.write("the left Node is:"+newNode.left.chStr+"\n");
		}
		if(newNode.right!=null){
			outFile5.write("the right Node is:"+newNode.right.chStr+"\n");
		}
		
		
	}
}
