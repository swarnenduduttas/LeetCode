class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int elem1 = Integer.MIN_VALUE;
        int elem2 = Integer.MIN_VALUE;
        List<Integer> res = new ArrayList<>();

        for (int j : nums) {
            if (count1 == 0 && j != elem2) {
                count1++;
                elem1 = j;
            } else if (count2 == 0 && j != elem1) {
                count2++;
                elem2 = j;
            } else if (j == elem1) {
                count1++;
            } else if (j == elem2) {
                count2++;
            } else {
                count2--;
                count1--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == elem1) {
                count1++;
            } else if (num == elem2) {
                count2++;
            }
        }
        int min = nums.length / 3 + 1;

        if (count2 >= min)
            res.add(elem2);
        if (count1 >= min)
            res.add(elem1);
        return res;
    
    }
}