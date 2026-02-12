class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(Character c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            } else if(st.isEmpty()){
                return false;
            } else if(c == ')' && st.peek() == '('){
                st.pop();
            } else if(c == '}' && st.peek() == '{'){
                st.pop();
            } else if(c == ']' && st.peek() == '['){
                st.pop();
            } else {
                st.push(c);
            }
        }
        return st.isEmpty();
    }
}