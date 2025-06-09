class Solution {
    public int removeElement(int[] nums, int val) {
        int j = -1;
        for(j =0; j<nums.length; j++){
            if(nums[j] == val){
                break;
            }
        }

        for(int i = j+1; i<nums.length; i++){
            if(nums[i] != val){
                nums[j] = nums[i];
                nums[i] = val;
                j++;
            }
        }  
        return j;     
    }
}