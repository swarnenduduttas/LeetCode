class Solution {
    
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map1 = new HashMap<>();
        map1.put('2', "abc");
        map1.put('3', "def");
        map1.put('4', "ghi");
        map1.put('5', "jkl");
        map1.put('6', "mno");
        map1.put('7', "pqrs");
        map1.put('8', "tuv");
        map1.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        StringBuilder diary = new StringBuilder();

        func(digits, 0, diary, res, map1);

        return res;
    }

    void func(String digits, int indx, StringBuilder diary, List<String> res, Map<Character, String> map1) {
        if (indx == digits.length()) {
            res.add(diary.toString());
            return;
        }

        String choice = map1.get(digits.charAt(indx));

        for (int i = 0; i < choice.length(); i++) {
            diary.append(choice.charAt(i));
            func(digits, indx+1, diary, res, map1);
            diary.deleteCharAt(diary.length()-1);
        }

    }
}