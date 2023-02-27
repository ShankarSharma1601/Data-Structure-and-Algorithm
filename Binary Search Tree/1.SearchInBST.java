// Search in Binary Search Tree
// Time Complexity : O(h)  where h = height of the BST
// Space Complexity : O(1)


class Solution{
    boolean search(Node node , int val){
        if(node == null) return false;

        if(node.data == val) return true;
        else if(node.data > val) return search(node.left , val);
        else return search(node.right , val);
    }
}

