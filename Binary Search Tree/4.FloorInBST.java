// Floor in BST
// Time Complexity : O(h) where h = height of the BST
// Space Complexity : O(1)


class Solution {
    public static int floorBST(Node root, int key) {
        if (root == null) return -1;
        int floor = -1;
        while(root != null){
            if(root.data == key){
                floor = root.data;
                return floor;
            }
            if(root.data > key){
                root = root.left;
            }
            else{
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }
}