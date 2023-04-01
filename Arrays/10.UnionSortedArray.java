// Union of Two Sorted Array
// 3 Approaches


// Using Map
// Time Complexity : O((m+n)log(m+n))
// Space Complexity : O(m+n)

class Solution{
    static ArrayList<Integer> findUnion(int a[] , int b[] , int n , int m){
        HashMap<Integer , Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int val : a){
            map.put(val , map.getOrDefault(val , 0) + 1);
        }

        for(int val : b){
            map.put(val , map.getOrDefault(val , 0) + 1);
        }

        for(int val : map.keySet()){
            ans.add(val);
        }

        return ans;
    }
}


// Using Set
// Time Complexity : O((m+n)log(m+n))
// Space Complexity : O(m+n)

class Solution{
    static ArrayList<Integer> findUnion(int a[] , int b[] , int n , int m){
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int val : a){
            set.add(val);
        }

        for(int val : b){
            set.add(val);
        }

        for(int val : set){
            ans.add(val);
        }

        return ans;
    }
}


// Two Pointer
// Time Complexity : O(m+n)
// Space Complexity : O(1)

class Solution{
    static ArrayList<Integer> findUnion(int a[] , int b[] , int n , int m){
        int i = 0 , j = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        while(i < n && j < m){
            if(a[i] <= b[j]){
                if(ans.size() == 0 || ans.get(ans.size() - 1) != a[i]){
                    ans.add(a[i]);
                }
                i++;
            }
            else{
                if(ans.size() == 0 || ans.get(ans.size() - 1) != b[j]){
                    ans.add(b[j]);
                }
                j++;
            }
        }

        while(i < n){
            if(ans.get(ans.size() - 1) != a[i]){
                ans.add(a[i]);
            }
            i++;
        }

        while(j < m){
            if(ans.get(ans.size() - 1) != b[j]){
                ans.add(b[j]);
            }
            j++;
        }

        return ans;
    }
}