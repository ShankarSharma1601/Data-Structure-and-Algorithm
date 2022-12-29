// Preorder , Inorder , Postorder Traversal in One Traversal
// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution{
    public static void allTraversal(Node root , List<Integer> pre , List<Integer> in , List<Integer> post){
        Stack<pair> stack = new Stack<>();
        stack.push(new pair(root , 1));

        if(root == null) return ;

        while(!stack.isEmpty()){
            pair p = stack.pop();
            //this is part of pre, incerment 1 to 2 and push the left side of the tree
            if(p.num == 1){
                pre.add(p.node.data);
                p.num++;
                stack.push(p);
                if(p.node.left != null){
                    stack.push(new pair(p.node.left , 1));
                }
            }
            //this is part of in, increment 2 to 3 and push right
            else if(p.num == 2){
                in.add(p.node.data);
                p.num++;
                stack.push(p);
                if(p.node.right != null){
                    stack.push(new pair(p.node.right , 1));
                }
            }
            else{
                post.add(p.node.data);
            }
        }
    }
}

class pair{
    Node node;
    int num;
    pair(Node node , int num){
        this.node = node;
        this.num = num;
    }
}