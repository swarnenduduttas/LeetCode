class Solution {
    public int splitArray(int[] arr, int k) {
        int low = 0;
        int high = 0;
        for (int j : arr) {
            low = Math.max(low, j);
            high = high + j;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            int painters = paintersNeeded(mid, arr);
            if (painters > k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
        
    }

    private int paintersNeeded(int mid, int[] arr) {
        int painters = 1;
        int work = 0;
        for (int j : arr) {
            if (work + j <= mid)
                work = work + j;
            else {
                painters++;
                work = j;
            }
        }
        return painters;
    }
}