class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();
        int ans = 0;
        while(low<= high){
            int mid = (low+high)/2;
            if(possible(nums, threshold, mid)){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return ans;

    }

    boolean possible(int[] nums, int threshold, int mid){
        int sum = 0;
        for(int i =0; i<nums.length; i++){
            sum += Math.ceilDiv(nums[i], mid);
        }
        return sum<= threshold;
    }
}