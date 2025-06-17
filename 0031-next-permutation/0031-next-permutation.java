class Solution {
    public void nextPermutation(int[] nums) {
        int index =-1;
        int n = nums.length;
        //find the index
        for(int i = n-2; i>= 0; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            reverse(0, n-1, nums);
            return;
        }

        //swap with the first greater
        for(int i = n-1; i>index; i--){
            if(nums[i]>nums[index]){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        

        //reverse the numbers after index
        int first = index+1;
        int last = n-1;
        reverse(first, last, nums);
        
    }

    void reverse(int first, int last, int[] nums){
        while(first<=last){
            int temp = nums[first];
            nums[first] = nums[last];
            nums[last] = temp;
            first++;
            last--;
        }
    }
}