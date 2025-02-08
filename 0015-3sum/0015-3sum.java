class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set1 = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int k = -(nums[i]+nums[j]);
                if(set1.contains(k)){
                    List<Integer> triplet = Arrays.asList(nums[i],nums[j],k);
                    triplet.sort(null);
                    res.add(triplet);
                }
                set1.add(nums[j]);
            }
        }
        return new ArrayList<>(res);
    }
}