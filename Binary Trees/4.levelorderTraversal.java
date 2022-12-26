// Level Order Traversal
// Time Complexity : O(N)
// Space Complexity : O(N)


class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int k = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i = 0; i < k;i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            ans.add(level);
        }
        return ans;
    }
}