class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
         Set<List<Integer>> res = new HashSet<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Set<Long> set = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = nums[i] + nums[j];
                    sum += nums[k];
                    long fourth = (target - sum);
                    if (set.contains(fourth)) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], (int) fourth);
                        Collections.sort(list);
                        res.add(list);
                    }
                    set.add((long) nums[k]);
                }
            }
        }
        return new ArrayList<>(res);
    }
}