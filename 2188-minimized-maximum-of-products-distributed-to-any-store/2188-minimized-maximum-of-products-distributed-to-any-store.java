class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = Arrays.stream(quantities).max().getAsInt();
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            if(stores(mid, quantities) <= n){
                ans = mid;
                high = mid-1;
            } else{
                 low = mid+1;
            }
        }

        return ans;
        
    }

    int stores(int mid, int[] quantities){
        int stores = 0;
        for(int i =0; i<quantities.length; i++){
            stores = stores + Math.ceilDiv(quantities[i], mid);
        }
        return stores;
    }
}