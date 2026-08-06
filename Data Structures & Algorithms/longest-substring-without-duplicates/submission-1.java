class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> seen = new HashMap<>();
        int left = 0, right = 0, maxLen = 0;

        for(right = 0; right < s.length(); right++) {
            if(!seen.containsKey(s.charAt(right)) || (seen.get(s.charAt(right)) < left)) {
                seen.put(s.charAt(right), right);
                maxLen = Math.max(maxLen, right - left + 1);
            } else {
                left = seen.get(s.charAt(right)) + 1;
                seen.put(s.charAt(right), right);
            }
        }
        return maxLen;
    }
}
