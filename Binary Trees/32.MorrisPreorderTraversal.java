// Morris Preorder Traversal 
// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution{
    static ArrayList<Integer> morrisPreorder(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        Node curr = root;

        while(curr != null){
            if(curr.left == null){
                ans.add(curr.data);
                curr = curr.right;
            }
            else{
                Node prev = curr.left;
                while(prev.right != null && prev.right != curr){
                    prev = prev.right;
                }
                if(prev.right == null){
                    prev.right = curr;
                    ans.add(curr.data);
                    curr = curr.left;
                }
                else{
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
        return ans;
    }
}