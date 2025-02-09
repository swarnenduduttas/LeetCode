class Solution {
    public int subarraySum(int[] nums, int k) {
        int countSeq = 0;
        int preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            preSum += num;
            int removal = preSum - k;
            countSeq += map.getOrDefault(removal, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return countSeq;
    }
}