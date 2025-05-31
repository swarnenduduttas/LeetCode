class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 0){
            return false;
        }
        int l = 1;
        int h = num;
        
        while(l<=h){
            int mid = (l+h)/2;
            long midSq = (long)mid*mid;
            if( midSq == num){
                return true;
            } else if(midSq > num) {
                h = mid-1;
            } else {
                l = mid+1;
            }
        }
        return false;
    }
}