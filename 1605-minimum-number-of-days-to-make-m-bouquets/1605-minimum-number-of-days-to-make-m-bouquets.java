class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int ans = -1;
        int[] temp = Arrays.copyOf(bloomDay, bloomDay.length);
        Arrays.sort(temp);
        int low = temp[0];
        int high = temp[temp.length - 1];
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