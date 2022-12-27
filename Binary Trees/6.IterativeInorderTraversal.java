// Iterative Inorder Traversal
// Time Complexity : O(N)
// Space Complexity : O(N)

class Solution{
    public List<Integer> iterativeInorder(Node root){
        List<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans; 
        }

        Stack<Node> stack = new Stack<>();

        while(true){
            if(root != null){
                stack.push(root);
                root = root.left;
            }
            else{
                if(stack.isEmpty()) break;
                root = stack.pop();
                ans.add(root.data);
                root = root.right;
            }
        }

        return ans;
    }
}