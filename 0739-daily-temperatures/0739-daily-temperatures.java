class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        ArrayList<Integer> res = new ArrayList<>();
        res.add(0);

        for(int i = n-2; i>=0; i--){
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res.add(0);
            } else {
                res.add(st.peek() - i);
            }
            st.push(i);
        }
        Collections.reverse(res);
        return res.stream().mapToInt(i->i).toArray();
    }
}