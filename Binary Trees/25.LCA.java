// Lowest Common Ancestor in a Binary Tree
// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution{
    //Function to return the lowest common ancestor in a Binary Tree.
	Node lca(Node root, int n1,int n2){
		if(root == null || root.data == n1 || root.data == n2){
		    return root;
		}
		
		Node left = lca(root.left , n1 , n2);
		Node right = lca(root.right , n1 , n2);
		
		if(left == null) return right;
		else if(right == null) return left;
		else return root;
	}
}
