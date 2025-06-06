class Solution {
    public int characterReplacement(String s, int k) {
       int left = 0;
        int right = 0;
        int[] arr = new int[26];
        int maxFreq = 0;
        int maxLen = 0;
        while (right < s.length()) {
            arr[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, arr[s.charAt(right) - 'A']);
            if (right - left + 1 - maxFreq > k) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }
}