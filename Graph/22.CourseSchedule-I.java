// Course Schedule I


class Solution{
    public boolean canFinish(int numCourses , int[][] prerequisites){

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0;i < numCourses;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i < prerequisites.length;i++){
            int pre = prerequisites[i][1];
            int ready = prerequisites[i][0];
            adj.get(ready).add(pre);
        }

        int indegree[] = new int[numCourses];
        for(int i = 0;i < numCourses;i++){
            for(Integer nbr : adj.get(i)){
                indegree[nbr]++;
            }
        }

        Queue<Integer> queue =  new LinkedList<>();
        for(int i = 0;i < numCourses;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }

        int count = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;
            for(Integer nbr : adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    queue.add(nbr);
                }
            }
        }

        if(count == numCourses) return true;
        return false;
    }
}