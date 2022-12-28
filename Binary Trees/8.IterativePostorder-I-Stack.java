// PostOrder Traversal using 2 Stack
// Time Complexity : O(N)
// Space Complexity : O(N)

class Solution{
    public List<Integer> iterativePostorder(Node root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Stack<Node> stack = new Stack<>();
        while(root != null || !stack.isEmpty()){
            if(root  != null){
                stack.push(root);
                root = root.left;
            }
            else{
                Node temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    ans.add(temp.data);
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        ans.add(temp.data);
                    }
                }
                else root = temp;
            }
        }

        return ans;
    }
}