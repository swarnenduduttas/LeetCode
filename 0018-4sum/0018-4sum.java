class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length; // size of the array
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            for (int j = i + 1; j < n; j++) {
                if (nums[j - 1] == nums[j] && j > i + 1)
                    continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];

                    if (sum == target) {
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        res.add(list);
                        k++;
                        l--;
                        while (nums[k] == nums[k - 1] && k < l)
                            k++;
                        while (nums[l] == nums[l + 1] && k < l)
                            l--;
                    } else if (sum > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return res;
    }
}