// Course Schedule II

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0;i < numCourses;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0;i < prerequisites.length;i++){
            int pre = prerequisites[i][1];
            int ready = prerequisites[i][0];
            adj.get(pre).add(ready);
        }
        
        int indegree[] = new int[numCourses];
        for(int i = 0;i < numCourses;i++){
            for(Integer nbr : adj.get(i)){
                indegree[nbr]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i < numCourses;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        
        int ans[] = new int[numCourses];
        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            ans[count++] = node;
            for(Integer nbr : adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    queue.add(nbr);
                }
            }
        }
        
        if(count == numCourses) return ans;
        else return new int[]{};
    }
}