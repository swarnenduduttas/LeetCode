class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int res = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int i = mid;

            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                res = mid;
                high = mid -1;
            }
        }
        return res;
    }
}