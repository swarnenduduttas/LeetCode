class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        find(1, k, n, ds, res);
        return res;
    }

    void find(int i, int size, int sum,  List<Integer> ds, List<List<Integer>> res) {
        if(size == 0){
            if(sum == 0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }
        if(i>9){
            return;
        }
        ds.add(i);
        find(i+1, size-1, sum - i, ds, res);
        ds.removeLast();
        find(i+1, size, sum, ds, res);
    }
}