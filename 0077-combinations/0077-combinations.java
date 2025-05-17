class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        getCombo(n, k, ds, res);
        return res;
    }

    void getCombo(int n, int k, List<Integer> ds, List<List<Integer>> res) {
        if(n == 0){
            if(k == 0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }
        ds.add(n);
        getCombo(n-1, k-1, ds, res);
        ds.removeLast();
        getCombo(n-1, k, ds, res);
    }
}