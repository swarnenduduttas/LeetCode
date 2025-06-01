class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int ans = -1;

        while(low<=high){
            int mid = (low+high)/2;
            if(possible(bloomDay, k, m, mid)){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    boolean possible(int[] bloomDay, int k, int m, int day){

        int counter = 0;
        int bouquet = 0;
        for(int i = 0 ; i< bloomDay.length; i++){
           
            if(bloomDay[i]<= day){
                counter++;
            } else {
                bouquet+= counter/k;
                counter = 0;
            }
        }
        bouquet += counter/k;;
        
        return bouquet >= m;
    }
}  