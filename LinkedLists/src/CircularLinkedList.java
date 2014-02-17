
public class CircularLinkedList {
	Node head;

	CircularLinkedList(){
		head=null;
	}

	 void insert(Node node, int data){
			if(node==null){
				this.head=new Node(data);
			}
			if(node.next==this.head){
				node.next=new Node(data);
				node.next.next=this.head;
				return;
			}
			else{
				insert(node.next,data);
			}
	 }
	//Iterative reverse of a circular linked list
		static void iterativeReverse(Linkedlists list){
			Node current=list.head;
			Node previous=null;
			Node nextNode=null;
			while(current.next != list.head){
				nextNode=current.next;
				current.next=previous;
				previous=current;
				current=nextNode;
			}
			current.next=previous;
			list.head.next=current;
			list.head=current;

		}

		//Recursive reverse of a circular linked list
		static void recursiveReverse(Linkedlists list){

		}

		private void recursiveReverse(Node node){

		}

		//Cutting a circular linked list into two halves
		static void cutCircList(Linkedlists list1, Linkedlists list2, Linkedlists list,Object data){
			Node current=list.head;
			list1.head=list.head;
			//Node list1N=list1.head;
			//Node list2N=list2.head;
			while(current.next != list.head){
				if(current.data==data){
					list2.head=current.next;
					current.next=null;
					current=list2.head;
					continue;
				}

			current=current.next;
			}
			current.next=null;

		}


		//Determine if a linkedlist has a loop, return loop starting and then remove the loop.
		static void detectLoop(Linkedlists list){
			Node slow=list.head;
			Node fast=list.head;
			int flag=0;
			while(slow !=null && fast !=null && fast.next !=null){
				slow=slow.next;
				fast=fast.next.next;
				if(slow==fast){
					System.out.println("loop detected");
					flag=1;
					System.out.println(slow.data);
					removeLoop(list, slow);

					return;
				}

			}
			if(flag==0){
				System.out.println("no loop in the list");
				}
		}

		private static void removeLoop(Linkedlists list, Node node){
			Node ptr1=node;
			Node ptr2=node;

			//find the number of nodes in the loop
			int k=1;
			while(ptr1.next != ptr2){
				ptr1=ptr1.next;
				k++;
			}
			System.out.println("number of nodes in the loop:"+k);

			//Find the starting point of the loop.
			//First place one pointer k nodes ahead of the head node and the move them at the same speed to find the starting point
			ptr1 =list.head;
			ptr2=list.head;
			for(int i=0;i<k;i++){
				ptr2=ptr2.next;
			}

			//Now move them at same speed and they will collide at the starting point
			while(ptr1 != ptr2){
				ptr1=ptr1.next;
				ptr2=ptr2.next;
			}
			System.out.println("loop starting point:" +ptr1.data);
			ptr1=ptr1.next;
			while(ptr1.next !=ptr2){
				ptr1=ptr1.next;
			}
			ptr1.next=null;

		}

		public static void main(String args[]){
			Node a,b,c,d,e;
			Linkedlists list1=new Linkedlists();
			list1.appendToTail(1);
			a=new Node(2);
			b=new Node(3);
			c=new Node(4);
			d=new Node(5);
			e=new Node(6);
			a.next=b;
			b.next=c;
			c.next=d;
			d.next=e;
			list1.head.next=a;
			e.next=a;

			CircularLinkedList.detectLoop(list1);
			list1.printList();
		}
}
