package test;
public class Main {
	
	public static void main(String[] args) {
		int lenght = Integer.parseInt(args[0]);
		Node root = null;
		int i;
		for(i=1;i<=lenght;i++){
			root = Tree.insertNode(root, Integer.parseInt(args[i]));
		}
		
		System.out.print("Original Tree: ");
		
		printPreOrder(root);
		System.out.println();
		root = Operation.minimiseTree(root, Integer.parseInt(args[i++]), Integer.parseInt(args[i]));
		System.out.print("Modified Tree: ");
		printPreOrder(root);
	}
	
	public static void printPreOrder(Node root){
		if(root == null)
			return;
		System.out.print(root.data + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}

}
