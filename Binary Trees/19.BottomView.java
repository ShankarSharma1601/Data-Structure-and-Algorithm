// Bottom view of a Binary Tree
// Time Complexity: O(N)
// Space Complexity: O(N)



class Solution{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root){
       
       ArrayList<Integer> ans = new ArrayList<>();
       if(root == null) return ans;
       
       Map<Integer , Integer> map = new TreeMap<>();
       Queue<Node> queue = new LinkedList<>();
       queue.add(root);
       root.hd = 0;
       while( !queue.isEmpty()){
           Node node = queue.poll();
           int hd = node.hd;
           map.put(hd , node.data);
           if(node.left != null){
               node.left.hd = hd - 1;
               queue.add(node.left);
           }
           if(node.right != null){
               node.right.hd = hd + 1;
               queue.add(node.right);
           }
       }
       
       for(Map.Entry<Integer , Integer> mpp : map.entrySet()){
           ans.add(mpp.getValue());
       }
       return ans;
    }
}

class Node{
    int data;
    int hd; // horizontal distance
    Node left , right;
    Node(int val){
        data = val;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}