// Construct Tree from Inorder & Preorder
// Time Complexity: O(N)
// Space Complexity: O(N)



class Solution{
    public static Node buildTree(int inorder[], int preorder[], int n){
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            map.put(inorder[i] , i);
        }
        
        Node root = buildTree(preorder , 0 , preorder.length - 1 , inorder , 0 , inorder.length - 1 , map);
        return root;
    }
    private static Node buildTree(int pre[] , int ps , int pe , int in[] , int is , int ie , HashMap<Integer , Integer> map){
        if(ps > pe || is > ie) return null;
        
        Node root = new Node(pre[ps]);
        int index_in_map = map.get(root.data);
        int nums_in_left = index_in_map - is;
        
        root.left = buildTree(pre ,ps+1 , ps + nums_in_left , in , is , index_in_map - 1 , map );
        root.right = buildTree(pre , ps + nums_in_left + 1 , pe , in , index_in_map + 1 , ie , map);
        
        return root;
    }
}