class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int ans = Integer.MAX_VALUE;
        int low = 1;
        int high = maxInArray(piles);
        while (low <= high) {
            int mid = (low + high) / 2;
            long hours = findHours(piles, mid);

            if (hours <= h) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private long findHours(int[] piles, int hourlyRate) {
        long hours = 0;
        for (int pile : piles) {
            hours = hours + Math.ceilDiv(pile, hourlyRate);
        }
        return hours;
    }

    private int maxInArray(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        return max;
    }
}