// Serialize and Deserialize a Binary Tree
// Time Complexity : O(n)
// Space Complexity : O(n)



class Solution {
    //Function to serialize a tree and return a list containing nodes of tree.
	public void serialize(Node root, ArrayList<Integer> A) {
	    if(root == null){
	        A.add(-1);
	        return ;
	    }
	    A.add(root.data);
	    serialize(root.left , A);
	    serialize(root.right , A);
	}
	
	int index = 0;
	//Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A){
        if(index == A.size()) return null;

        int value = A.get(index++);
        if(value == -1) return null;

        Node root = new Node(value);
        root.left = deSerialize(A);
        root.right = deSerialize(A);

        return root;
    }
};



// Alternative Solution

 class Solution {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if(root == null) return "";
        Queue<TreeNode> queue = new LinkedList();
        StringBuilder  ans = new StringBuilder();
       
        queue.add(root);
        while( !queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                 ans.append("n ");
                 continue;
            }
            ans.append(node.val + " ");
            
            queue.add(node.left);
            queue.add(node.right);
        }
        return ans.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if(data == "") return null;
        Queue<TreeNode> queue = new LinkedList();
        String [] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for(int i= 1;i<values.length;i++){
            TreeNode parent = queue.poll();
            if( !values[i].equals("n")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            if( !values[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
         
    }
}

