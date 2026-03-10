class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMaxElem(piles);
        int res = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (hoursNeeded(piles, mid) > h) {
                low = mid + 1;
            } else {
                res = Math.min(res, mid);
                high = mid - 1;
            }
        }
        return res;
    }

    int findMaxElem(int[] piles) {
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            res = Math.max(res, piles[i]);
        }
        return res;
    }

    long hoursNeeded(int[] piles, int rate) {
        long res = 0;

        for (int i = 0; i < piles.length; i++) {
            res += Math.ceilDiv(piles[i],rate);
        }

        return res;
    }
}