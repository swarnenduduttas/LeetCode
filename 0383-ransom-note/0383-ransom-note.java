class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> ranMap = new HashMap<>();
        for(Character c : ransomNote.toCharArray()){
            ranMap.put(c, ranMap.getOrDefault(c,0)+1);
        }
        HashMap<Character, Integer> magMap = new HashMap<>();
        for(Character c : magazine.toCharArray()){
            magMap.put(c, magMap.getOrDefault(c,0)+1);
        }
        for(Map.Entry<Character, Integer> e: ranMap.entrySet()){
            if(!magMap.containsKey(e.getKey()) || magMap.get(e.getKey()) < e.getValue()){
                return false;
            }
        }
        return true;
    }
}