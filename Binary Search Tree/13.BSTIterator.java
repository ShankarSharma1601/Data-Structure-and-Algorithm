// Binary Search Tree Iterator
// Time Complexity : O(n)
// Space Complexity : O(h)


class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }
    
    public int next() {
        TreeNode ans = stack.pop();
        pushAll(ans.right);
        return ans.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    private void pushAll(TreeNode node) {
        TreeNode temp = node;
        while(temp != null){
            stack.push(temp);
            temp = temp.left;
        }
    }
}


// Alternate Solution
class BSTIterator{
    List<Integer> list = null;
    Iterator it = null;
    public BSTIterator(TreeNode root){
        list = new ArrayList<>();
        traverse(root , list);
        it = list.listIterator();
    }
    private void traverse(TreeNode root , List list){
        if(root != null){
            traverse(root.left , list);
            list.add(root.val);
            traverse(root.right , list);
        }
    }
    public int next(){
        return (int)it.next();
    }
    public boolean hasNext(){
        return it.hasNext();
    }
}