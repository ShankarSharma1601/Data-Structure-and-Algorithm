// Merge Interval
// interval[i] = [start , end]
// Time Complexity : O(nlogn)
// Space Complexity : O(n)

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]>ans = new ArrayList<>();
        
        if(intervals.length == 0 || intervals == null){
            return ans.toArray(new int[0][]);
        }
        
        Arrays.sort(intervals , (a , b)-> a[0] - b[0] );
        
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        for(int []interval : intervals){
            if(interval[0] <= end){
                end = Math.max(end , interval[1]);
            }
            else{
                ans.add(new int[]{start , end});
                start = interval[0];
                end = interval[1];
            }
        }
        ans.add(new int[]{start , end});
        return ans.toArray(new int[0][]);
    }
}