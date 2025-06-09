class Solution {
    public void moveZeroes(int[] nums) {
        int j =-1;
        for( j =0; j< nums.length; j++){
            if(nums[j] == 0){
                break;
            }
        }

        for(int i=j+1; i< nums.length; i++){
            if(nums[i] != 0){
                nums[j] =  nums[i];
                nums[i] = 0;
                j++;
            }
        }
        
    }
}