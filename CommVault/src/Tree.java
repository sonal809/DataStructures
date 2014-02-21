
public class Tree {

	public static Node insertNode(Node root, int data){
		if(root == null){
			root = new Node(data);
			return root;
		} else {
			if(root.data > data){
				root.left  = insertNode(root.left, data);
			} else {
				root.right  = insertNode(root.right, data);
			}
		}
		return root;

	}

}
