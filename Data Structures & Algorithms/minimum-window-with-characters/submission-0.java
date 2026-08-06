class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        
        for(Character c: t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int left = 0, resLen = Integer.MAX_VALUE, have = 0, need = countT.size();
        int[] res = {-1,-1};

        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if(countT.containsKey(c) && countT.get(c).equals(window.get(c))) {
                have++;
            }

            while(have == need) {
                if(resLen > (right - left + 1)) {
                    resLen = right - left + 1;
                    res[0] = left;
                    res[1] = right;
                }

                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);
                if(countT.containsKey(leftChar) && countT.get(leftChar) > window.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }
        
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
