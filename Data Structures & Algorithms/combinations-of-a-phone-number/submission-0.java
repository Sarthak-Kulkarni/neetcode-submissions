class Solution {
    String[] lettersMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private void letterComb(List<String> res, String comb, String digits) {
        if(digits.length() == 0) {
            if(comb.length() > 0) {
                res.add(comb);
            }
            return;
        }
        
        String letters = lettersMap[digits.charAt(0) - '2'];
        for(char letter: letters.toCharArray()) {
            letterComb(res, comb + letter, digits.substring(1));
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        letterComb(res, "", digits);
        return res;
    }
}
