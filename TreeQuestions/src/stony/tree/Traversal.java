package stony.tree;

import java.util.*;

public class Traversal {
	static void inorder(Tree tree){

		System.out.println("\n Inorder traversal:");
		Node current=tree.root;
		Stack<Node> treeStack=new Stack<>();
		boolean done=false;
		while(!done){
			if(current == null && treeStack.isEmpty()){
				done=true;
				return;
			}
			if(current == null){
				current=treeStack.pop();
				System.out.print(" "+current.data);
				current=current.right;
				if(current != null){
					treeStack.push(current);
					current=current.left;
				}
				continue;
			}
			else{
			treeStack.push(current);
			current=current.left;
			}
		}
	}

	static void postorder(Tree tree){

		System.out.print("\n Postorder traversal: \n");
		Node current=tree.root;
		Stack<Node> treeStack=new Stack<>();
		boolean done=false;
		current.visited=false;
		Node temp=null;
		treeStack.push(current);
		while(!done){
			if(current == null && treeStack.isEmpty()){
				done=true;
				return;
			}
				if(current == null){
					Node current1=treeStack.peek();
					if(current1.visited==true){
						current1=treeStack.pop();
						System.out.print(" " + current1.data);
					}
					else{
					current1.visited=true;
					if(current1.right==null){
						current1=treeStack.pop();
						System.out.print(" "+current1.data);
					}
					else{

						current=current1.right;
						treeStack.push(current);
					}
					}
				}/*
					current=treeStack.pop();
					temp=current;
					current=current.right;
					if(current ==null){
						System.out.print(" " +temp.data);
					}
					else{
						treeStack.push(current);
						current=current.left;
					}

					continue;
				}*/

				else{
					current=current.left;
					if(current!=null){
						treeStack.push(current);
					}

			}
		}
	}

	static void BFS(Tree tree){

		System.out.print(" \n BFS traversal:");
		Node current=tree.root;
		current.visited=false;
		Queue<Node> queue=new LinkedList<>();
		boolean done=false;
		while(!done){
			if(current == null && queue.isEmpty()){
				done=true;
				return;
			}
			if(current==null){
				current=queue.poll();
				continue;
			}
			if(current.visited==true){
				System.out.print(" " + current.data);
				current=queue.poll();
				continue;
			}
			else if (current.visited==false){

				current.visited=true;
				queue.add(current.left);
				//System.out.println("current.left "+current.left);
				queue.add(current.right);
				continue;
			}


		}
	}


}
