// Square Root of a number
// Time Complexity : O(logn)
// Space Complexity : O(1)

class Solution{
     long floorSqrt(long x){
		long low = 0 , high = x;
		while(low <= high){
		    long mid = low + (high - low) / 2;
		    if(mid * mid == x) return mid;
		    else if(mid * mid > x) high = mid - 1;
		    else low = mid + 1;
		}
		return high;
	 }
}