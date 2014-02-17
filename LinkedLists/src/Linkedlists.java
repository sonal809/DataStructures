
class Node{
	Object data;
	Node next=null;
	Node(){
		next=null;
	}
	public Node(char d){
		this.data=d;
		this.next=null;
	}
	public Node (Object d){
		this.data=d;
		this.next=null;
	}
}
public class Linkedlists {


	Node head;

	Linkedlists(){
		head=null;
	}
	Linkedlists(Object arr[], char r){
		for(int i=0;i<arr.length-1;i++){
			appendToTail(arr[i]);
		}
	}
	Linkedlists(Object arr[]){
		head=new Node(arr[0]);
		Node current[]=new Node[arr.length];
		current[0]=head;
		for(int i=1;i<=arr.length-1;i++){
			current[i]=new Node(arr[i]);
			current[i-1].next=current[i];
		}
	}


	void appendToHead(Object data){
		if (head==null){
			head=new Node(data);
		}
		else{
			Node newNode=new Node(data);
			newNode.next=head;
			head=newNode;
		}
	}
	void appendToTail(Object data){
		Node end=new Node(data);
		if (head==null){
			head=new Node(data);
		}
		else{
		Node current=head;
		while(current.next != null){
			current=current.next;

		}
		current.next=end;
		//System.out.print(current.data + "	");
		}
	}

	int length(){
		int count=0;
		Node current=head;
		while(current != null){
			current=current.next;
			count++;
		}
		//System.out.println("length of the linked list is :" + count);
		return count;
	}

	void printList(){
		Node current=head;

		System.out.println("\n The list is:");
		while(current != null){
			System.out.print(current.data + " ");
			current=current.next;

		}
	}
	void removeNode(Object data){
		int flag=0;
		Node current=head;


		System.out.println("Deleting Node: " + data);
		if(head.data==data){
			flag=1;
			head=head.next;
			return ;
		}
		while(current.next != null){
			if(current.next.data==data){
				current.next=current.next.next;
				flag=1;
			}
			else{
			current=current.next;
			}
		}

		if(flag==0){
			System.out.println("item does not exist in the list");
		}

	}
	Object getNode(int k){
		Node current=head;
		int count=1;
		int flag=0;
		Object data=null;
		while(current != null){
			if(count==k){
				flag=1;
				data= current.data;
				break;
			}
			current=current.next;
			count++;
		}
		if (flag==0){
			System.out.println("Index is wrong");
			return false;
			}
		else return data;
	}

	void printCircList(){
		System.out.println("\n The circular linked list is:");
		Node current=this.head;
		while(current.next != head){
			System.out.print(" " + current.data);
			current=current.next;
		}
		System.out.print(" " +current.data);
	}

	void printCircListR(){
		System.out.println("\n The circular linked list is:");
		printCircListR(this.head);

	}
	private void printCircListR(Node node){
		if (node.next==this.head){
			System.out.println(" "+ node.data);
			return;
		}
		else{
			System.out.print(" " + node.data);
			printCircListR(node.next);
		}
	}

	 //Recursive reverse of a linked list.
	 void reverseR(Node node){
		 Node first=node;
		 Node rest=first.next;

		 if(rest.next==null) {
			 first.next.next=first;
			 this.head=rest;
			 return;
		 }
		 reverseR(rest);
		 first.next.next=first;
		 first.next=null;


	 }



	public static void main(String args[]){
		Linkedlists list1=new Linkedlists();

		list1.appendToTail('F');
		list1.appendToTail('O');
		list1.appendToTail('L');
		list1.appendToTail('L');
		list1.appendToTail('k');
		list1.appendToTail('O');
		list1.appendToTail('W');
		list1.length();
		list1.printList();
		//Problems.removeDuplicates(list1);
		list1.removeNode('m');

		//Problems.deleteDup(list1);
		list1.printList();
		System.out.println();
		Problems.printKtoLast(list1, 3);

		Node a,b,c,d,e;
		Linkedlists list2=new Linkedlists();
		list2.appendToTail(1);
		a=new Node(2);
		b=new Node(3);
		c=new Node(4);
		d=new Node(5);
		e=new Node(6);
		a.next=b;
		b.next=c;
		c.next=d;
		d.next=e;
		list2.head.next=a;
		e.next=list2.head;


		//list2.printCircListR();
		/*list2.insert(list2.head, 7);
		list2.printCircListR();
		Problems.iterativeReverse(list2);
		list2.printCircListR();
		Linkedlists clist1=new Linkedlists();
		Linkedlists clist2=new Linkedlists();
		Problems.cutCircList(clist1, clist2, list2, 5);*/
		//Problems.deleteNode(d);
		/*System.out.println("The new lists are: ");
		clist1.printList();
		clist2.printList();*/
		//list2.printList();

		Object arr[]=new Object[] {4,8,7,5,9,0,3,10,2};
		Linkedlists list3=new Linkedlists(arr);
		list3.printList();
		/*int x=7;
		Problems.partionList(list3, x);
		System.out.println("\n" + "partition about element " + x);
		list3.printList();

		Object arr1[]=new Object[]{9,9,9};
		Object arr2[]=new Object[]{9,9,9};
		Linkedlists list4=new Linkedlists(arr1);
		Linkedlists list5=new Linkedlists(arr2);
		Linkedlists result=Problems.addLists(list4, list5);
		result.printList();

		list3.printList();
		Problems.reverse(list3);
		System.out.println("\n the list after reversing:");
		list3.printList();*/


		//list3.reverseR(list3.head);
		//list3.printList();

		list3.removeNode(2);
		list3.printList();
		Problems.deleteNode(c);
		list2.printList();


	}
}
