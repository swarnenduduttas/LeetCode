class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
       if (bloomDay.length < (long) m * k) return -1; // Not enough flowers
        
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoid overflow
            if (canMakeBouquets(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private boolean canMakeBouquets(int[] bloomDay, int days, int m, int k) {
        int count = 0, bouquets = 0;

        for (int bloom : bloomDay) {
            if (bloom <= days) {
                count++;
                if (count == k) { // Enough flowers for one bouquet
                    bouquets++;
                    count = 0;
                }
            } else {
                count = 0; // Reset counter if flowers aren't ready
            }
            if (bouquets >= m) return true; // Early exit if requirement met
        }
        return false;
    }

}