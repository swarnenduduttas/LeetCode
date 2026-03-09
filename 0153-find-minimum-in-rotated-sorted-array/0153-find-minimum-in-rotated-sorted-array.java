class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int guess = (low + high) / 2;
            if (nums[guess] > nums[high]) {
                ans = Math.min(ans, nums[guess]);
                low = guess + 1;
            } else {
                ans = Math.min(ans, nums[guess]);
                high = guess - 1;
            }
        }
        return ans;
    }
}