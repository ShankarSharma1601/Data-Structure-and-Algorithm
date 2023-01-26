// Maximum Width of Binary Tree
// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    // Function to get the maximum width of a binary tree.
    int getMaxWidth(Node root) {
        int ans = 0;
        if(root == null) return 0;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            int count = 0;
            for(int i = 0;i < size;i++){
                Node node = queue.poll();
                count++;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            ans = Math.max(ans , count);
        }
        return ans;
    }
}



// Another Solution

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root == null) return 0;
        
        int ans = 0;
        Queue<pair> queue = new LinkedList<>();
        queue.add(new pair(root , 0));
        while( !queue.isEmpty()){
            int size = queue.size();
            int min = queue.peek().index;
            int first = 0 , last = 0;
            for(int i = 0;i < size;i++){
                int curr_index = queue.peek().index - min;
                TreeNode node = queue.peek().node;
                queue.remove();
                if(i == 0) first = curr_index;
                if(i == size - 1) last = curr_index;
                if(node.left != null){
                    queue.add(new pair(node.left , 2*curr_index + 1));
                }
                if(node.right != null){
                    queue.add(new pair(node.right , 2*curr_index + 2));
                }
            }
            ans = Math.max(ans , last - first + 1);
        }
        return ans;
        
    }
}

class pair{
    TreeNode node;
    int index;
    pair(TreeNode node , int index){
        this.node = node;
        this.index = index;
    }
}