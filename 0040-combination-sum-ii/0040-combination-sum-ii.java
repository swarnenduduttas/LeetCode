class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates);
        find(0, candidates, target, ds, res);
        return res;
    }

    void find(int index, int[] cand, int target, List<Integer> ds, List<List<Integer>> res){
            if(target == 0){
                res.add(new ArrayList<>(ds));
                 return;
            }
           

        for(int i = index; i<cand.length; i++){
            if(i > index && cand[i] == cand[i-1]){
                continue;
            } 
            if(cand[i]>target) {
                break;
            }
            ds.add(cand[i]);
            find(i+1, cand, target-cand[i], ds, res);
            ds.removeLast();
        }
    }
}