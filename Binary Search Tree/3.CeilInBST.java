// Ceil in BST
// Time Complexity : O(h) where h = height of the BST
// Space Complexity : O(1)


class Solution {
    int findCeil(Node root, int key) {
        if (root == null) return -1;
        int ceil = -1;
        while(root != null){
            if(root.data == key){
                ceil = root.data;
                return ceil;
            }
            if(root.data < key){
                root = root.right;
            }
            else{
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }
}