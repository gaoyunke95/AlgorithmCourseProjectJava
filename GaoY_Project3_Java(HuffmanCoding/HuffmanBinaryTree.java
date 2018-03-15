import java.io.BufferedWriter;
import java.io.IOException;

public class HuffmanBinaryTree {

	HuffmanLinkedList a= new HuffmanLinkedList();
	listBinTreeNode root;
	
	listBinTreeNode printN= new listBinTreeNode();
	public HuffmanBinaryTree(listBinTreeNode listHead,BufferedWriter outFile1,BufferedWriter outFile5) throws IOException{
		listBinTreeNode oldListHead= new listBinTreeNode();
		oldListHead.next=listHead.next;
		listBinTreeNode newNode = new listBinTreeNode();
		
		while(oldListHead.next.next!=null){
			a.listHead=oldListHead;
			newNode= new listBinTreeNode();
			
			newNode.chStr=oldListHead.next.chStr+oldListHead.next.next.chStr;
			newNode.prob=oldListHead.next.prob+oldListHead.next.next.prob;
			
			newNode.left=oldListHead.next;
			newNode.right=oldListHead.next.next;
			
			oldListHead.next=oldListHead.next.next.next;
			
			listBinTreeNode spot=a.findSpot(newNode.prob);
			a.listInsert(spot, newNode);
			
			printN.printNode(newNode, outFile5);
			outFile5.write(a.printList());
			
		}
		root=newNode;
		
	}
	
	

	
	public void preOrderTraveral(listBinTreeNode newRoot,BufferedWriter outFile2) throws IOException{
		if(newRoot==null){
		}
		else{
			outFile2.write(newRoot.chStr+" "+newRoot.prob+"\n");
			preOrderTraveral(newRoot.left,outFile2);	
			preOrderTraveral(newRoot.right,outFile2);
		}
	}
	public void inOrderTraveral(listBinTreeNode newRoot,BufferedWriter outFile3) throws IOException{
		if(newRoot==null){
		}
		else{
			inOrderTraveral(newRoot.left,outFile3);
			outFile3.write(newRoot.chStr+" "+newRoot.prob+"\n");	
			inOrderTraveral(newRoot.right,outFile3);
		}
	}
	public void postOrderTraveral(listBinTreeNode newRoot,BufferedWriter outFile4) throws IOException{
		if(newRoot==null){
		}
		else{
			postOrderTraveral(newRoot.left,outFile4);	
			postOrderTraveral(newRoot.right,outFile4);
			outFile4.write(newRoot.chStr+" "+newRoot.prob+"\n");
		}
	}
	public boolean isLeaf(listBinTreeNode newRoot){
		if(newRoot.left==null&&newRoot.right==null){
			return true;
		}
		return false;
	}

	void CharCode(listBinTreeNode root,String code,BufferedWriter outFile1) throws IOException{
		if(root==null){
			System.out.println("this is empty tree");
		}
		else if(isLeaf(root)){
			outFile1.write(root.chStr);
			root.code=code;
			outFile1.write(" code is :" +root.code+"\n");	
		}
		else{
			CharCode(root.left,code+"0",outFile1);
			CharCode(root.right,code+"1",outFile1);
		}
		
	}


	
}
