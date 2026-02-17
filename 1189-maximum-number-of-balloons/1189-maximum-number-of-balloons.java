class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] have = new int[26];
        int[] need = new int[26];
        String balloon = "balloon";
        for(Character c : balloon.toCharArray()){
            need[c - 'a']++;
        }
        for(Character c : text.toCharArray()){
            have[c - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0 ; i< need.length; i++){
            if(need[i] > 0){
               if(need[i] > have[i]){
                return 0;
               }
               res = Math.min(res, have[i]/need[i]);
            }
            
        }
        return res;
    }
}