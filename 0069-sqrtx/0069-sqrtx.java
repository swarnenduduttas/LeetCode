class Solution {
    public int mySqrt(int x) {
        if(x == 0){
            return 0;
        }
        int l = 1;
        int h = x;
        int ans = 0;
        while(l<=h){
            int mid = (l+h)/2;
            if(mid <= x/mid){
                ans = mid;
                l = mid+1;
            } else {
                h = mid-1;
            }
        }
        return ans;
    }
}