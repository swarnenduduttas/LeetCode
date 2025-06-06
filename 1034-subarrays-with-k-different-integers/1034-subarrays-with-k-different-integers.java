class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return findSubArrayCount(nums, k) - findSubArrayCount(nums, k - 1);
    }

    private int findSubArrayCount(int[] nums, int k) {
        int count = 0;
        int l = 0;
        int r = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (r < nums.length) {
            if (map.containsKey(nums[r])) {
                map.put(nums[r], map.get(nums[r]) + 1);
            } else {
                map.put(nums[r], 1);
            }

            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0)
                    map.remove(nums[l]);
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }
}