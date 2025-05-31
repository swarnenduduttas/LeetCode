class Solution {
    public boolean judgeSquareSum(int c) {

    long l = 0;
        long h = (long) Math.sqrt(c);

        while (l <= h) {
            long product = l * l + h * h;
            if (product == c) {
                return true;
            } else if (product > c) {
                h--;
            } else {
                l++;
            }
        }

        return false;
        
    }
}