import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.io.*;
		
public class main {

		private static  Scanner x;
		private static  FileInputStream fstream;
		private static  String input;
		private static int prob;
	//	static LinkedList link= new LinkedList();
		static HuffmanLinkedList link= new HuffmanLinkedList();
		//HuffmanBinaryTree tree= new HuffmanBinaryTree();
		
	public static void main(String[] args) throws IOException{
		BufferedWriter outFile1= new BufferedWriter(new FileWriter(args[1]));
		BufferedWriter outFile2= new BufferedWriter(new FileWriter(args[2]));
		BufferedWriter outFile3= new BufferedWriter(new FileWriter(args[3]));
		BufferedWriter outFile4= new BufferedWriter(new FileWriter(args[4]));
		BufferedWriter outFile5= new BufferedWriter(new FileWriter(args[5]));
		 
		try{
			 fstream= new FileInputStream(args[0]);
			 x= new Scanner(fstream);
		 }
		 catch(Exception e){
			 System.out.println("no file find");
		 }

		 while(x.hasNext()){
	
			 listBinTreeNode spot;
			 
			 input=x.next();
			 prob=x.nextInt();
			 listBinTreeNode newNode= new listBinTreeNode(input,prob);
			 
			 spot=link.findSpot(prob);
			 link.listInsert(spot, newNode);
			
			 outFile5.write(link.printList());
			 link.size++;

		 }
		listBinTreeNode root;
		HuffmanBinaryTree tree= new HuffmanBinaryTree(link.listHead,outFile1,outFile5);
		root=tree.root;
		tree.CharCode(root, "", outFile1);
		tree.preOrderTraveral(root, outFile2);
		tree.inOrderTraveral(root, outFile3);
		tree.postOrderTraveral(root, outFile4);
		
		 x.close();
		 fstream.close();
		 outFile1.close();
		 outFile2.close();
		 outFile3.close();
		 outFile4.close();
		 outFile5.close();
	}
	
}
