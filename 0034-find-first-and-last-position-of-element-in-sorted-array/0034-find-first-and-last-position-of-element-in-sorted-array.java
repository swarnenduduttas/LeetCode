class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{firstIndex(nums, target), lastIndex(nums, target)};
    }

    private int lastIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid;
        int ans = -1;
        while (low <= high) {
            mid = (low + high) / 2;

            if(nums[mid] == target){
                ans = mid;
                low = mid+1;
            } else if (target<nums[mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    private int firstIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int mid;
        int ans = -1;
        while (low <= high) {
            mid = (low + high) / 2;

            if (nums[mid] == target) {
                ans = mid;
                high = mid-1;
            } else if (target<nums[mid]) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }
}