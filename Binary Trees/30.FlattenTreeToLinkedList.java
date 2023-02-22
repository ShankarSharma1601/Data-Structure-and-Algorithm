// Flatten Binary Tree to LinkedList
// Time Complexity : O(n)
// Space Complexity : O(n)


class Solution{
    public void flatten(Node root){
        if(root != null){
            Node temp = root.right;
            root.right = root.left;
            root.left = null;
            Node node = root;
            while(node.right != null){
                node = node.right;
            }
            node.right = temp;
            flatten(root.right);
        }
    }
}

// Alternative Solution
class Solution{
    Node prev = null;
    void flatten(Node root){
        if(root == null) return ;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }
}