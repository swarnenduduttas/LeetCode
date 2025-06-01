class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low = 1;
        int high = findMax(candies);
        int ans = 0;

        while(low<= high){
            int mid = (low+high)/2;
            long child = findChild(candies, mid);
            if(child >=k){
                ans = Math.max(ans, mid);
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }

    private long findChild(int[] candies, int mid) {
        long child = 0;
        for (int candy : candies) {
            child += candy / mid;
        }
        return child;
    }

    private int findMax(int[] candies) {
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        return max;
    }
}