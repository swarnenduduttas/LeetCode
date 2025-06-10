class Solution {
    public int findDuplicate(int[] nums) {
        //using the Floyd's two pointer algo
       int slow = 0;
       int fast = 0;

       while(true){
        slow = nums[slow];
        fast = nums[nums[fast]];
        if(fast == slow){
            break;
        }
       }
       int pointer = 0;

       while(true){
        slow = nums[slow];
        pointer = nums[pointer];
        if(slow == pointer){
            break;
        }
       }
       return pointer;
    }
}