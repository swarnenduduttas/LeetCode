class Solution {
     public int numberOfSubarrays(int[] nums, int k) {
        return findCount(nums, k) - findCount(nums, k - 1);
     }
    public static int findCount(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;

        while (right < nums.length) {
            sum += nums[right]%2;
            while (sum > k) {
                sum -= nums[left]%2;
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
        
    }
}