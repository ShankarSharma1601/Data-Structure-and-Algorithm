// PostOrder Traversal using 2 Stack
// Time Complexity : O(N)
// Space Complexity : O(N + N)

class Solution{
    public List<Integer> iterativePostorder(Node root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);

        while(!stack1.isEmpty()){
            root = stack1.pop();
            stack2.push(root);
            if(root.left != null) stack1.push(root.left);
            if(root.right != null) stack1.push(root.right);
        }

        while(!stack2.isEmpty()){
            ans.add(stack2.pop().data);
        }

        return ans;
    }
}