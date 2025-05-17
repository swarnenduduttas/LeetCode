class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       List<List<Integer>> res = new ArrayList<>();
       findCombination(0, candidates, target, new ArrayList<Integer>(), res);
       return res;
    }

    void findCombination(int i, int[] nums, int target, List<Integer> ds,  List<List<Integer>> res){
        if(i == nums.length){
            if(target == 0){
                res.add(new ArrayList<Integer>(ds));
            }
            return;
        }

            if(nums[i]<= target){
                ds.add(nums[i]);
                findCombination(i, nums, target-nums[i], ds, res);
                ds.removeLast();
            }
            findCombination(i+1, nums, target, ds, res);
    }
}