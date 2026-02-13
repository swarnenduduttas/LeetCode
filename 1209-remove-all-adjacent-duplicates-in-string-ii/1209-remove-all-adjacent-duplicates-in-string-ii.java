class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<int[]> st = new Stack<>();

        for(Character c : s.toCharArray()){
            if(!st.isEmpty() && st.peek()[0] == c){
                if(st.peek()[1] == k-1){
                    st.pop();
                } else {
                    st.peek()[1]++;
                }
            } else {
                st.push(new int[]{c, 1});
            }
        }

        StringBuilder res = new StringBuilder();
        for(int[] pair:st){
            for(int i =0; i<pair[1]; i++){
                res.append((char)pair[0]);
            }
        }

        return res.toString();
    }
}