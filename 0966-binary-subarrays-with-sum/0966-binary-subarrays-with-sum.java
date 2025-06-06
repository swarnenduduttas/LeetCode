class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
         return findCount(nums, goal) - findCount(nums, goal-1);
    }

    private static int findCount(int[] nums, int goal) {
        if(goal < 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;

        while (right < nums.length) {
            sum += nums[right];
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}