class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(nums);
        find(0, nums, ds, res);
        return res;
    }

    void find(int index, int[] nums, List<Integer> ds, List<List<Integer>> res){
       // if(index == nums.length){
            res.add(new ArrayList<>(ds));
          //  return;
        //}

        for(int i = index ; i< nums.length; i++){
           
            if(i != index && nums[i] == nums[i-1]){
                continue;
            }
            ds.add(nums[i]);
            find(i+1, nums, ds, res);
            ds.removeLast();
        }
    }
}