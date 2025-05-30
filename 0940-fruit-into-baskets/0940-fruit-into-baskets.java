class Solution {
    public int totalFruit(int[] fruits) {
         int maxLen = 0;
        int l = 0;
        int r = 0;
        Map<Integer, Integer> map1 = new HashMap<>();

        while (r < fruits.length) {
            if (map1.containsKey(fruits[r])) {
                map1.put(fruits[r], map1.get(fruits[r]) + 1);
            } else {
                map1.put(fruits[r], 1);
            }

            if (map1.size() > 2) {
                while (map1.size() > 2) {
                    map1.put(fruits[l], map1.get(fruits[l]) - 1);
                    if (map1.get(fruits[l]) == 0) {
                        map1.remove(fruits[l]);
                    }
                    l++;
                }
            }

            maxLen = Math.max(maxLen, r - l + 1);

            r++;
        }

        return maxLen;
    }
}