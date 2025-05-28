class Solution {
   public int lengthOfLongestSubstring(String s) {
         char[] arr = s.toCharArray();
        int n = arr.length;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        int maxLen = 0;
        int len = 0;

        while (right < n) {
            if (map1.containsKey(arr[right]) )
                    left =  Math.max(map1.get(arr[right]) + 1, left);
            map1.put(arr[right], right);
            len = right-left+1;
            maxLen = Math.max(maxLen, len);
            right++;
        }
        return maxLen;
    }
}