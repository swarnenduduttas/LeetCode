class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magMap = new HashMap<>();
        for(Character c : magazine.toCharArray()){
            magMap.put(c, magMap.getOrDefault(c,0)+1);
        }
       for(Character c : ransomNote.toCharArray()){
        if(!magMap.containsKey(c) || magMap.get(c) == 0){
            return false;
        }
        magMap.put(c, magMap.get(c)-1);
       }
        return true;
    }
}