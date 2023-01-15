// Zig Zag Traversal 
// Time Complexity: O(N)   
// Space Complexity: O(N)

class Solution{
    ArrayList<Integer> zigZagTraversal(Node root){
	    
	  ArrayList<Integer> ans = new ArrayList<>();
	  if(root == null) return ans;
	  Queue<Node> queue = new LinkedList<>();
	  queue.add(root);
	  boolean left_to_right = true;
	  
	  while(!queue.isEmpty() ){
	      
	      int size = queue.size();
	      //ArrayList<Integer> row = new ArrayList<Integer>(size);
	      int []row = new int[size];
	      for(int i=0;i<size;i++){
	          
	          Node node = queue.peek();queue.remove();
	          
	          int index = (left_to_right) ? i : (size - 1 - i);
	          //row.add(index, node.data);
	          row[index] = node.data;
	          if(node.left!=null) queue.add(node.left);
	          if(node.right!=null) queue.add(node.right);
	          
	          
	      }
	      left_to_right = !left_to_right;
	      
	     for(int val : row){
	         ans.add(val);
	     }
	      
	  }
	    
	    return ans;
    }
}