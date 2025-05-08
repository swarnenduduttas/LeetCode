class Solution {
    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length-1;

        if(nums.length == 1){
            return nums[0];
        }

        while(low<=high){
            int mid =(low+high)/2;
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                ans = Math.min(nums[low], ans);
                low = low+1;
                high = high-1;
                
                continue;
            }
            if(nums[mid]>= nums[low]){
                ans = Math.min(nums[low], ans);
                low = mid+1;
            } else {
                ans = Math.min(nums[low], nums[mid]);
                high = mid-1;
            }
        }

        return ans;
        
    }
}