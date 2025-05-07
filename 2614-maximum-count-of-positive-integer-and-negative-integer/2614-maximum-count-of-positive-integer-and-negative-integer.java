class Solution {
    public int maximumCount(int[] nums) {
        int pos = nums.length - positive(nums);
        int neg = negative(nums)+1;
        return Math.max(pos,neg);
    }

    int positive(int[] nums){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] > 0){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return low;
    }

    int negative (int[] nums){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = (high+low)/2;
            if(nums[mid]<0){
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return high;
    }
}