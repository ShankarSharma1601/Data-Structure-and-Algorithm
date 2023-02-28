// Minimum & Maximum element in BST
// Time Complexity : O(h) where h = height of the BST
// Space Complexity : O(1)

class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node node) {
        if(node == null) return -1;
        int min = node.data;
        while(node.left != null){
            node = node.left;
            min = Math.min(min , node.data);
        }
        return min;
    }
    // Function to find the maximum element in the given BST.
    int maxValue(Node node) {
        if(node == null) return -1;
        int max = node.data;
        while(node.right != null){
            node = node.right;
            max = Math.max(max , node.data);
        }
        return max;
    }
}
