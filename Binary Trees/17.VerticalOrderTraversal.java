// Vertical Order Traversal
// Time Complexity: O(N*logN*logN*logN)
// Space Complexity: O(N)

class Solution{
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Map<Integer , ArrayList<Integer>> map = new TreeMap<>();
        
        Queue<pair> queue = new LinkedList<>();
        queue.add(new pair(root , 0 , 0));
        
        while(!queue.isEmpty()){
            pair p = queue.poll();
            Node node = p.node;
            int row = p.row;
            int col = p.col;
            
            if(!map.containsKey(col)){
                map.put(col , new ArrayList<>());
            }
            if(map.containsKey(col)){
                ArrayList<Integer> temp = map.get(col);
                temp.add(node.data);
            }
            if(node.left != null){
                queue.add(new pair(node.left , row + 1 , col - 1));
            }
            if(node.right != null){
                queue.add(new pair(node.right , row + 1 , col + 1));
            }
        }
        
        for(Map.Entry<Integer , ArrayList<Integer>> mpp : map.entrySet() ){
            for(Integer val : mpp.getValue()){
                 ans.add(val);     
            }
           
        }
        return ans;
    }
}

class pair{
    Node node;
    int row;
    int col;
    pair(Node node , int row , int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}