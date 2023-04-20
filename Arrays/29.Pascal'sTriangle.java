// Pascal's Triangle
// Time Complexity : O(n^2) 
// Space Complexity : O(n^2) where n = no. of rows


class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row , pre = null;
        
        for(int i = 0 ; i < numRows;i++){
            row = new ArrayList<>();
            for(int j = 0;j<=i;j++){
                if(j == 0 || j == i) row.add(1);
                else row.add(pre.get(j) + pre.get(j-1));
            }
            pre = row;
            ans.add(row);
        }
        return ans;
    }
}