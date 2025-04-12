class Solution {
    public int search(int[] nums, int target) {
        int size = nums.length;
        int low = 0;
        int high = size - 1;
        int mid = Integer.MIN_VALUE;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;

            }
        }
        return -1;
        
    }
}