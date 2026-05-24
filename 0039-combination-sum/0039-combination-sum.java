class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> diary = new ArrayList<>();
        func(candidates, 0, diary, result, 0, target);
        return result;

    }

    void func(int[] arr, int idx, List<Integer> diary, List<List<Integer>> result, int sum, int target) {

        if(idx == arr.length || sum > target) {
            if(sum == target){
                result.add(new ArrayList(diary));
            }
            return;
        }

        diary.add(arr[idx]);
        sum+= arr[idx];
        func(arr, idx, diary, result, sum, target);
        sum -= arr[idx];
        diary.removeLast();
        func(arr, idx+1, diary,result, sum, target);
    }
}