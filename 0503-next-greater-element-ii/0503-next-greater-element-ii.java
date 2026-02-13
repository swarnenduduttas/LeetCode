class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        for(int i =n-2; i>=0; i--){
            st.push(nums[i]);
        }
        
        List<Integer> res = new ArrayList<>();
       
        for(int i = n-1; i>= 0; i--){
            while(!st.isEmpty() && st.peek() <= nums[i]){
                st.pop();
            }  
            if(st.isEmpty()){
                res.add(-1);
            } else {
                res.add(st.peek());
            }
            st.push(nums[i]);  
        }
        Collections.reverse(res);
        return res.stream().mapToInt(i->i).toArray();
    }
}