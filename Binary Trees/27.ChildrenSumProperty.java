// Children Sum Parent
// Time Complexity : O(n)
// Space Complexity : O(n)


class Solution{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node temp;
        while(!queue.isEmpty()){
            temp = queue.poll();
            int sum = 0;
            if(temp.left == null) sum += 0;
            else{
                sum += temp.left.data;
                queue.add(temp.left);
            }
            
            if(temp.right == null ) sum += 0;
            else{
                sum += temp.right.data;
                queue.add(temp.right);
            }
            
            if(sum != 0 && sum != temp.data){
                return 0;
            }
        }
        return 1;
    }
}


// Alternative Solution

class Solution{
    public static int isSumProperty(Node root){
        if (root == null) return;
        int child = 0;
        if (root.left != null) {
            child += root.left.data;
        }
        if (root.right != null) {
            child += root.right.data;
        }

        if (child < root.data) {
            if (root.left != null) root.left.data = root.data;
            else if (root.right != null) root.right.data = root.data;
        }

        isSumProperty(root.left);
        isSumProperty(root.right);

        int total = 0;
        if (root.left != null) total += root.left.data;
        if (root.right != null) total += root.right.data;
        if (root.left != null || root.right != null) root.data = total;
    }
}