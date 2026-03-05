class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] { firstPos(nums, target), lastPos(nums, target) };
    }

    int firstPos(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int res = -1;
        
        while (low <= high) {
            int mid = (high + low) / 2;
            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                res = mid;
                high = mid-1;
            }
        }
        return res;
    }

    int lastPos(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int res = -1;

        while (low <= high) {
            int mid = (high + low) / 2;
            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                res = mid;
                low = mid+1;
            }
        }
        return res;
    }

}