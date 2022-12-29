// Height of Binary Tree
// Level Order Traversal
// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution{
    public int levelOrder(Node root){
        if(root == null) return 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                Node node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            level++;
        }

        return level;
    }
}