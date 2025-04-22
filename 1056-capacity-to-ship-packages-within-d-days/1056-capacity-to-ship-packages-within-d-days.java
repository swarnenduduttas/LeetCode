class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
        int n = weights.length;
        for (int weight : weights) {
            low = Math.max(low, weight);
            high = high + weight;
        }
        while (low <= high) {
            int mid = (low + high) / 2;
            int daysRequired = calculateDaysRequired(mid, weights);
            if (daysRequired <= days)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }

    private int calculateDaysRequired(int mid, int[] weights) {
        int load = 0;
        int days = 1;
        for (int weight : weights) {
            if (weight + load > mid) {
                days = days + 1;
                load = weight;
            } else {
                load = load + weight;
            }
        }
        return days;
    }
}