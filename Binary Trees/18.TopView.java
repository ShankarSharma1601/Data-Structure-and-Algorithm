// Top View of binary tree
// Time Complexity: O(N)
// Space Complexity: O(N)


class Solution{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root){
       
       ArrayList<Integer> ans = new ArrayList<>();
       if(root == null) return ans;
       
       Queue<pair> queue = new LinkedList<>();
       Map<Integer , Integer> map = new TreeMap<>();
       
       queue.add(new pair(root , 0));
       while( !queue.isEmpty()){
           pair p = queue.poll();
           Node node = p.node;
           int hd = p.hd;
           
           if(!map.containsKey(hd)){
               map.put(hd , node.data);
           }
           if(node.left != null){
               queue.add(new pair(node.left , hd - 1));
           }
           if(node.right != null){
               queue.add(new pair(node.right , hd + 1));
           }
           
       }
       
       for(Map.Entry<Integer , Integer> mpp : map.entrySet()){
           ans.add(mpp.getValue());
       }
       return ans;
        
    }
}


class pair{
    Node node;
    int hd;// horizontal distance
    pair( Node n , int hd){
        node = n;
        this.hd = hd;
    }
}