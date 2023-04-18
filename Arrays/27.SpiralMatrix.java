// Spiral Matrix
// Time Complexity : O(R*C)
// Space Complexity : O(1)


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix.length == 0) return ans;
        
        int rb = 0 , cb = 0 , re = matrix.length - 1 , ce = matrix[0].length - 1;
        
        while(rb <= re && cb <= ce){
            
            for(int i = cb;i <= ce;i++){
                ans.add(matrix[rb][i]);
            }
            rb++;
            for(int i = rb;i <= re;i++){
                ans.add(matrix[i][ce]);
            }
            ce--;
            if(rb <= re){
               for(int i = ce;i >= cb;i--){
                  ans.add(matrix[re][i]);
               }
            }
            re--;
            if(cb <= ce){
               for(int i = re;i >= rb;i--){
                  ans.add(matrix[i][cb]);
               }
            }
            cb++;
        }
        return ans;
    }
}