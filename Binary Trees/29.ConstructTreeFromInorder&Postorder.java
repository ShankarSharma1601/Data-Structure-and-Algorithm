// Construct Tree from Postorder and Inorder
// Time Complexity: O(N)
// Space Complexity: O(N)


class Solution{
    //Function to return a tree created from postorder and inoreder traversals.
    Node buildTree(int in[], int post[], int n){
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            map.put(in[i] , i);
        }
        
        Node root = buildTree(post , 0 , post.length - 1 , in , 0 , in.length - 1 , map);
        return root;
    }
    private Node buildTree(int post[] , int ps , int pe , int in[] , int is , int ie , HashMap<Integer , Integer> map){
        if(ps > pe || is > ie) return null;
        
        Node root = new Node(post[pe]);
        int index_in_map = map.get(root.data);
        int nums_in_left = index_in_map - is;
        
        root.left = buildTree(post ,ps , ps + nums_in_left -1 , in , is , index_in_map - 1 , map );
        root.right = buildTree(post , ps + nums_in_left, pe - 1 , in , index_in_map + 1 , ie , map);
        
        return root;
    }
}
