class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack1 = new Stack<>();
        //stack1.push(s.charAt(0));
        for(int i =0; i< s.length(); i++){
            if(!stack1.isEmpty() && s.charAt(i) == stack1.peek()){
                stack1.pop();
            } else {
                stack1.push(s.charAt(i));
            }
        }
        StringBuilder res = new StringBuilder();
        while(!stack1.isEmpty()){
            res.append(stack1.pop());
        }
        return res.reverse().toString();
    }
}