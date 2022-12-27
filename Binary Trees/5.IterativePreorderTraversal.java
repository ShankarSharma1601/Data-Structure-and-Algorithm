// Iterative Preorder Traversal
// Time complexity : O(N)
// Space Complexity : O(N)

class Solution{
    public List<Integer> iterativePreorder(Node root){
        List<Integer> ans = new ArrayList<>();

        if(root == null){
            return ans;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            ans.add(node.data);
            if(node.right != null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);
        }

        return ans;
    }
}