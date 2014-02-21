



public class Operation {

	public static Node minimiseTree(Node root,int min, int max){

		if(root==null) return null;


		if(root.data< min){
			root=minimiseTree(root.right, min, max);;
		}

		else if(root.data>max){
			root=minimiseTree(root.left, min, max);;
		}
		else{
			root.right=minimiseTree(root.right, min, max);
			root.left=minimiseTree(root.left, min, max);
		}

		return root;
	}
}

