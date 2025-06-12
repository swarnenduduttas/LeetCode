class Solution {
    public void sortColors(int[] nums) {
        int low =0;
        int high = nums.length-1;
        int mid = 0;

        while(mid<=high){
            if(nums[mid] == 0){
                swap(low, mid, nums);
                mid++;
                low++;
            } else if(nums[mid] == 1){
                mid++;
            } else{
                swap(high, mid, nums);
                high--;
            }
        }
    }

    void swap(int left, int right, int[] nums){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}