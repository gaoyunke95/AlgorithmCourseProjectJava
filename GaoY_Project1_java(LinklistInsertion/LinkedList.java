public class LinkedList {
	int size=0;
	ListNode ListHead;
	ListNode walker;
	int count=0;
	public LinkedList(){
		ListHead= new ListNode();
	}
	
	public boolean isEmpty(){
		return(size==0);
	}
	
	public void listInsert(String b){
		ListNode newNode= new ListNode(b);
		walker=ListHead;		
		
		
		while(walker.next!=null && walker.next.data.compareTo(b)<0){
				walker=walker.next;
		}
		if(walker.next==null){
			walker.next=newNode;
			newNode.next=null;
			size++;
		}
		else{
			newNode.next=walker.next;
			walker.next=newNode;
			size++;
		}

	}
	public String printList() {
		
		ListNode printList= ListHead;
		String output="ListHead";
		
		if(printList.data=="dummy"&&printList.next==null){
			output+="-->("+printList.data+",null)";
			count=1;
		}
	
				
		else{
	
			while(printList.next!=null&&count<15){
				output+="-->("+printList.data+" ,"+ printList.next.data+")";
				printList=printList.next;
				count++;
			}
			if(printList.next==null){
				output+="-->("+printList.data+" ,null)";
			}
		}
		output+=System.lineSeparator();
		count=0;
		
		return output;
	}
	
}
