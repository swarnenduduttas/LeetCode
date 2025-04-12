class Solution {
    public int searchInsert(int[] nums, int x) {
        int low = 0;
        int high = nums.length-1;
        int result = nums.length;
        int mid;

        while(low<=high) {
            mid = (low+high)/2;
            if(nums[mid] >= x){
                result = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return result;
    }
}