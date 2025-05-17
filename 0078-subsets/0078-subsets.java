class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<Integer>(), res);
        return res;
    }

    void findSubsets(int index, int[] nums, List<Integer> ds, List<List<Integer>> res){
        if(index >= nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[index]);
        findSubsets(index+1,nums, ds,res);
        ds.removeLast();
        findSubsets(index+1,nums,ds ,res);
    }
}