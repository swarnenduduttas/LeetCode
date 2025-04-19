class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        int l = 1;
        int h = n - 2;
        while (l <= h) {
            int m = (h + l) / 2;
            if (nums[m] != nums[m - 1] && nums[m] != nums[m + 1]) {
                return nums[m];
            }
            if ((m % 2 == 1 && nums[m] == nums[m - 1]) || (m % 2 == 0 && nums[m] == nums[m + 1])) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return -1;
    }
}