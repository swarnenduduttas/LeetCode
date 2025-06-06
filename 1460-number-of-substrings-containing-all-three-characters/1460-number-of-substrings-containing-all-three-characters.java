class Solution {
    public int numberOfSubstrings(String s) {
         int count = 0;
        Map<Character, Integer> lastSeenMap = new java.util.HashMap<>(Map.of('a', -1, 'b', -1, 'c', -1));
        for (int i = 0; i < s.length(); i++) {
            lastSeenMap.put(s.charAt(i), i);
            if(lastSeenMap.get('a') != -1 && lastSeenMap.get('b') != -1 && lastSeenMap.get('c') != -1 ){
                count = count + 1 + Math.min(lastSeenMap.get('a'), Math.min(lastSeenMap.get('b'), lastSeenMap.get('c')));
            }
        }
        return count;
    }
}