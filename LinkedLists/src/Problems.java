import java.util.ArrayList;
import java.util.HashMap;


public class Problems {
 public static void removeDuplicates(Linkedlists list){
	 HashMap<Object, Integer> hash=new HashMap<>();
	 Node current=list.head;
	 while(current != null){
		 if(hash.containsKey(current.data)){
			 hash.put(current.data, hash.get(current.data)+1);
		 }
		 else{
			 hash.put(current.data, 1);
		 }
		 current=current.next;

	 }
	 printUniq(hash,list);


 }

static  void  printUniq(HashMap<Object, Integer> hash, Linkedlists list){
	 Node current=list.head;
	 System.out.println();
	 System.out.println("The unique characters are: ");
	 while(current != null){
		 if (hash.get(current.data)==1){
			 System.out.print(current.data);
		 }
		 current=current.next;
	 }
 }

//This method does not uses any string buffer but takes o(n^2) time
static void deleteDup(Linkedlists list){
	if(list.head==null){
		System.out.println("enmpty list");
		return;
	}
	else{
		Node current=list.head;
		while(current != null){
			Node runner=current;
		while(runner.next != null){
			if(runner.next.data==current.data){
				runner.next=runner.next.next;
				list.removeNode(current.data);
			}
			else{
				runner=runner.next;
			}
		}
		current=current.next;
		}
	}

	System.out.println("list after duplicate removal");
	list.printList();
}

static void printKtoLast(Linkedlists list,int k){
	int count=1;
	System.out.println("Print k th element to the last element of the list, k=" + k);
	Node current=list.head;
	while(current !=null){
		if(count==k){
			System.out.print(" " + current.data);
			current=current.next;
			continue;
		}
		current=current.next;
		count++;
	}
}

	static void deleteNode(Node node){
		//Cannot handle last node deletion
		if(node.next==null){
			node=null;
		}
		node.data=node.next.data;
		node.next=node.next.next;
	}

	static void partionList(Linkedlists list, Object x){
	Linkedlists copyList1=new Linkedlists();
	Linkedlists copyList2=new Linkedlists();
	Node current=list.head;
	Node xnode=new Node(x);
	while(current.next != null){
		if ((int)current.data > (int) x){
			copyList2.appendToTail(current.data);
		}
		else if ((int)current.data < (int) x){
			copyList1.appendToTail(current.data);
		}
		current=current.next;
	}
	xnode.next=copyList2.head;
	Node current1=copyList1.head;
	while(current1.next != null){
		current1=current1.next;
	}
	current1.next=xnode;
	list.head=copyList1.head;
	}

	static Linkedlists addLists(Linkedlists list1, Linkedlists list2){
		Linkedlists result=new Linkedlists();
		int len1=list1.length();
		int len2=list2.length();
		int pad=list1.length()-list2.length();
		//System.out.println("pad:"+ pad);
		if(pad>0){
			padList(list2, pad);
			len2=len2+pad;
		}
		else {
			padList(list1, -pad);
			len1=len1-pad;
		}
		int tempResult, carry=0, sum;

		for(int i=0;i<list1.length();i++){
			tempResult=(int)list1.getNode(len1-i)+ (int)list2.getNode(len2-i)+carry;
			sum=tempResult % 10;
			result.appendToHead(sum);
			carry=tempResult / 10;
		}
		if(carry>0){
			result.appendToHead(carry);
		}
		return result;
	}
	private static void padList(Linkedlists list, int k){
		while(k>0){
			list.appendToHead(0);
			k--;
		}
	}

	//reverse a linked list
	static void reverse(Linkedlists list){
		Node current=list.head;

		Node nextNode=null;
		Node previous=null;
		while(current != null){
			nextNode=current.next;
			//System.out.println("current.next:"+current.data);
			current.next=previous;
			previous=current;
			current=nextNode;

		}
		//current.next=previous;
		list.head=previous;

	}






}

