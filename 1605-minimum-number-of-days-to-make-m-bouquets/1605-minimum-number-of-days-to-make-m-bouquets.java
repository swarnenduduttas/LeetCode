class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
       int ans = -1;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int i = 0; i< bloomDay.length; i++){
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(bloomDay, mid, m, k)) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private boolean possible(int[] bloomDay, int days, int m, int k) {
        int counter = 0;
        int bouquet = 0;

        for (int j : bloomDay) {
            if (j <= days) {
                counter++;
            } else {
                bouquet = bouquet + (counter / k);
                counter = 0;
            }
        }
        bouquet = bouquet + (counter / k);
        return bouquet >= m;
    }
}