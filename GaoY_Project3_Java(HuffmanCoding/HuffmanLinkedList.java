

public class HuffmanLinkedList {
	int size=0;
	listBinTreeNode listHead;
	listBinTreeNode spot;
	
	
	public HuffmanLinkedList(){
		listHead= new listBinTreeNode("dummy",0);
	}

	public listBinTreeNode findSpot(int prob){
		listBinTreeNode walker;
		listBinTreeNode spot=null;
		walker=listHead;
		
		while(walker.next!=null){
			if(walker.next.prob>=prob){
				spot=walker;
				return spot;
			}
			else{
				walker=walker.next;
			}
		}
		if(walker.next==null){
			spot=walker;
		}
		return spot;
	}
	
	public void listInsert(listBinTreeNode spot, listBinTreeNode newNode ){
	
		
		newNode.next=spot.next;
		spot.next=newNode;
	}
	public boolean isEmpty(){
		return(size==0);
	}
	public String printList(){
		String word="";
		
		listBinTreeNode printList= listHead;
		
		if(printList.chStr=="dummy"&&printList.next==null){
			word+="ListHead-->("+printList.chStr+printList.prob+",null)";
			
		}
	
		else{
			word+=("ListHead");
			while(printList.next!=null){
				//System.out.print("ListHead");
				word+=("-->("+printList.chStr+" ,"+ printList.prob+","+printList.next.chStr+")");
				printList=printList.next;	
			}
			if(printList.next==null){
				word+="-->("+printList.chStr+","+printList.prob+" ,null)";
			}
			
		}
		word+='\n';
		return word;
	}
	
}
