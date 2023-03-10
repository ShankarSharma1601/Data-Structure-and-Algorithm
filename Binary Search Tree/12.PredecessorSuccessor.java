// Predecessor & Successor
// Time Complexity : O(h)
// Space Complexity : O(h)


class Solution{
    public static void findPreSuc(Node root, Res p, Res s, int key){
       if(root == null) return ;
       
        if( key > root.data){
            p.pre = root;
            findPreSuc(root.right, p, s, key);
        }
        else if(key < root.data){
            s.succ = root;
            findPreSuc(root.left, p, s, key);
        }
        else{
            findPreSuc(root.right, p, s, key);
            findPreSuc(root.left, p, s, key);
        }
    }
}

class Res{
    Node pre = null;
    Node succ = null;
}