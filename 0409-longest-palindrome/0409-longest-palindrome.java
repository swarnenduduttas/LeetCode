class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map1 = new HashMap<>();
        for(Character c : s.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0)+1);
        }
        int len = 0;
        boolean isOdd = false;

        for(Map.Entry<Character, Integer> e : map1.entrySet()){
            int freq = e.getValue();
            if(freq%2 == 0){
                len = len + freq;
            } else if(freq == 1) {
                isOdd = true;
            } else {
                isOdd = true;
            }
        }

        if(!isOdd){
            return len;
        }

        for(Map.Entry<Character, Integer> e : map1.entrySet()){
            int freq = e.getValue();
            if(freq%2 != 0){
                len = len + freq-1;
            }
        }

        return len+1;
    }
}