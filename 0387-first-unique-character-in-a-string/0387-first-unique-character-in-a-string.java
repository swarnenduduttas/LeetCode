class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map1 = new HashMap<>();

        for(int i =0; i<s.length(); i++){
            Character c = s.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0)+1);
        }

        for(int i =0; i<s.length(); i++){
            Character c = s.charAt(i);
            if(map1.get(c) == 1){
                return i;
            }
        }

        return -1;
    }
}