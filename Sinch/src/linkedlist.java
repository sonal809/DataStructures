public class linkedlist{
	Node first;
	Node current;
	linkedlist(int data){
		Node n = new Node(data);
		first=n;
		current=first;
	}
	
class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;		
	}
	}

	public void appendtotail(int data){
		Node n= new Node(data);
		current.next = n;
		current = n;
	}
	
	void appendtohead(int data){
		Node n= new Node(data);
		//first = current;
		n.next = first;
		//n=current;
		first=n;
		current = first;
	}
	
	public void length(){
		int count=0;
		current = first;
		while (current != null){
			count++;
			current= current.next;
		}
		System.out.println("\nLength is=" + count);
	}
	
	public void display(){
		current=first;
		System.out.println();
		while(current !=null){
			System.out.print("	" + current.data);
				current= current.next;
		}
	}
	
	void gethead(){
		System.out.println("Head element is: " +first.data);
	}
	
	
	void gettail(){
		current=first;
		while (current.next != null){
			current = current.next;
			//System.out.println ("Current-->" + current.data);
		}
		System.out.println ("The tail element is: " + current.data);		
	}
	
	void deletehead(){
		current = first.next;
		System.out.println("After Head deletion:	");
		while(current !=null){
			System.out.print("	" + current.data);
				current= current.next;
		}
	}
	
	void deletetail(){
		current=first;
		System.out.println("\nAfter Tail deletion:	");
		while (current.next != null){
			System.out.print ("	" + current.data);
			current = current.next;
		}
	}
	
	void deletemiddle(int x){
		System.out.println ("The linked list after deletion of a middle element is: ");
		current = first;
		if (current.data ==x){
			first = first.next;
		}
		while (current.next != null){
			if(current.next.data == x){
				current.next = current.next.next;
				//current = current.next;
			}
		//	System.out.print(" " + current.data);
			current = current.next;
		}
	//	System.out.print(" " + current.data); // To print the last element
	}
	
	void removeduplicates(){
		current = first;
		
		while (current != null){
			Node n = current;
			while (n.next !=null){
			if (current.data == n.next.data){
				n.next = n.next.next;
			}
			else n= n.next;
			}
			current = current.next;
		}
	}
	
	void k_node(int k){
		int count=0;
		Node n;
		current = first;
		System.out.println();
		hulu : {
			while (current != null){
			count++;
			if(count == k){
				n = current;
				current = n;
				while (current != null){
					System.out.print("	" + current.data);
					current= current.next;
				}
				break hulu;
			}
			current= current.next;
		}
		}
	}
	
	void sort (int i){
		Node greater=null;
		Node smaller = null;
		current = first;
		System.out.println(current.data);
		while (current != null){
			if (current.data < i){
				current.next = smaller;
				smaller = current;
			}
			else{
				current.next = greater;
				greater = current;
			}
			current = current.next;
		}
		while (smaller.next !=null){
			smaller= smaller.next;
		}
		smaller.next = greater;
	}
	
	public static void main(String args[]){
		linkedlist l = new linkedlist(12);
		l.appendtotail(23);
		l.appendtotail(37);
		l.appendtotail(87);
		l.appendtotail(21);
		l.appendtohead(4598);
		//l.display();
		//l.length();
		//l.gethead();
		//l.gettail();
		//l.removeduplicates();
		//l.deletehead();
		//l.deletetail();
		//l.deletemiddle(23);
		//l.display();
		//l.k_node(4);
		l.sort(23);
		l.display();
	}
}