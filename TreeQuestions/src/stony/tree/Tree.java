package stony.tree;
import java.util.*;
class Node{
	Node left;
	Node right;
	Node parent;
	int data;
	boolean visited;


	Node(int newData){
		this.left=null;
		this.right=null;
		this.visited=false;
		this.parent=null;
		this.data=newData;

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return data+"";

	}
}
public class Tree {
	Node root;
	Node parent=null;
	//Create an empty tree
	Tree(){
		root=null;
		//root.parent=null;
	}

	private Node insert(Node node, int data){
		if (node==null){
		node=new Node(data);
		node.parent=parent;
		}
		else{
		if(node.data <= data){
			parent=node;
			node.right=insert(node.right, data);

		}
		else {
			parent=node;
			node.left=insert(node.left, data);
			}
		}

		return node;
	}
	void insert(int data){
		root=insert(root, data);
	}
	void insert(int arr[]){
		for (int i=0;i<arr.length;i++){
			root=insert(root,arr[i]);
		}
	}
	void lookup(int data){
		//System.out.println("root check again " + root.data);
		lookup(root,data);
	}
	private Node lookup(Node node,int data){
		if(node==null){
			System.out.println("Item does not exist");
			return null;
		}

		if(node.data==data){
			System.out.println(data+ " found");
			return node;
		}
		else if(node.data >= data)
			lookup(node.left,data);
			else {
				lookup(node.right, data);
			}

		return node;
	}

	int height(Node node){
		if(node==null) return 0;
		return Math.max(height(node.right), height(node.left)) +1;
	}

	int heightWrong(Node node){
		int height=0;
		Node current=node;
		Queue<Node> levelNodes=new LinkedList<>();
		boolean done=false;
		while(!done){
			if(levelNodes.isEmpty() && current ==null){
				done=true;
				//System.out.println("\n Height of the tree is " + (height-1));
				return height;

			}
			if(levelNodes.isEmpty()==false){
				current=levelNodes.remove();
				continue;
			}
			else{
			if(current.left !=null) levelNodes.add(current.left);
			if(current.right!=null) levelNodes.add(current.right);
			height++;
			}
		}

		return height;
	}

	//Deleting a node. No duplicate entries allowed
	void delete(int data){
		delete(this.root,data);
		}
	private void delete(Node node, int data){

		Node parent=getParent(node.data);
		if(node.data==data){

			if(node.left== null && node.right==null){
				if(parent.left.data==node.data){
					parent.left=null;
				}
				else
					parent.right=null;
				}
			else if(node.left == null || node.right==null){
				if(node.right==null){
					if(parent.left==node){
					parent.left=node.left;
					}
					else{
						parent.right=node.left;
					}
				}
					else{
						if(parent.right==node){
							parent.right=node.right;
						}
						else{
							parent.left=node.right;
						}
					}
			}
			else{
				//Find the minimum node from the right subtree. i.e. the the leftmost leaf of the rightsubtree.
				Node successor=this.findMin(node.right);
				System.out.println("successor:"+ successor.data);
				delete(node.right, successor.data);
				node.data=successor.data;
				//System.out.println("Succ:"+successor.data);
				//delete(successor,successor.data);
			}
		}

		else if(node.data<data){
			delete(node.right,data);
		}
		else{
			delete(node.left,data);
		}
	}

	private Node findMin(Node node){
		while(node.left != null){
			node=node.left;
		}
		return node;
	}



	//Nice function
	int noOfNodes(Node node){
		if (node==null) return 0;
		else
			return noOfNodes(node.left)+1 +noOfNodes(node.right);
	}

	//get parent of a node
	Node getParent(int data){
		Node current=this.root;
		Node parent=this.root;;

		System.out.println();
		while(current != null){
			if(current.data==data){
				return parent;
			}
			else if	(current.data>data){
				parent=current;
					current=current.left;
				}
			else{
					parent=current;
					current=current.right;
			}
		}
		if(current==null){
			System.out.println("no such item in the list");
		}
		return parent;
	}

	public static void main(String args[]){
		Tree t1=new Tree();
		t1.insert(4);
		t1.insert(7);
		t1.insert(3);
		t1.insert(9);
		//t1.insert(7);
		t1.insert(2);
		t1.insert(1);
		t1.insert(5);
		t1.insert(10);
		t1.insert(6);
		t1.insert(8);
		//System.out.println("try lookup");
		//t1.lookup(9);
		//Traversal.BFS(t1);

		Node succ=TreeProblems.inorderSucc(t1, t1.root.right.left.right);
		System.out.println("Inorder successor of 2::"+succ.data);
		Traversal.postorder(t1);

		Traversal.inorder(t1);
		int in[]={1,2,3,4,5,6,7,8,10};
		int pre[]={4,3,2,1,6,5,8,7,10};
		int post[]={1,2,3,5,7,10,8,6,4};
	//	Node root=TreeProblems.buildTree(in, pre, 0, in.length-1, 0, pre.length-1);
		//Node root=TreeProblems.buildTree2(in, post, 0, in.length-1, 0, post.length-1);
		//System.out.println(root.data);
		/*System.out.println("\n tree1:");
		//Traversal.BFS(t1);
		//t1.height(t1.root);
		//System.out.println("\n check for balancing");
		//TreeProblems.balancedTree(t1);
		int arr1[]={5,3,7,2,4,8,6};
		int arr2[]={10,5,3,7,2,4,6,8};
		int arr3[]={10,3,4};
		int arr4[]={10,3,2};
		Tree t2=new Tree();
		Tree t3=new Tree();
		Tree t4=new Tree();
		Tree t5=new Tree();
		t4.insert(arr3);
		t2.insert(arr1);
		t3.insert(arr2);
		t5.insert(arr4);
		System.out.println("\n tree4:");
		Traversal.BFS(t4);
		System.out.println("\n tree 1:");
		Traversal.BFS(t1);
		System.out.println("\n tree 2:");
		Traversal.BFS(t2);

		System.out.println("\n tree 3:");
		Traversal.BFS(t3);
		Traversal.inorder(t3);
		//System.out.println("\n height of the tree is "+ t1.height(t1.root));
		System.out.println("\n tree before:");
		Traversal.inorder(t1);;
		System.out.println("\n deleting a node");
		t1.delete(6);
		Traversal.inorder(t1);
		//TreeProblems.balancedTree(t2);
		TreeProblems.subtree(t2,t3);

		Traversal traverse=new Traversal();
		traverse.inorder(t1);


		ArrayList<LinkedList<Node>> result=new ArrayList<>();
		System.out.println("\n height of the tree is "+ t1.height(t1.root));
		result=TreeProblems.bfslist(t1);
		System.out.println("number of levels" +result.size());*/

		//TreeProblems.deepestLeftNode(t1);
		System.out.println();
		Tree rTree=TreeProblems.mirrorTree(t1);
		Traversal.BFS(rTree);
		Traversal.inorder(rTree);

		TreeProblems.printPaths(t1.root);
		TreeProblems.duplicateTree(t1.root);
		Traversal.inorder(t1);
	}
}
