class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> freqMap = new HashMap<>();
        int left = 0, res = 0, maxFreq = 0;

        for(int right = 0; right < s.length(); right++) {
            freqMap.put(s.charAt(right), freqMap.getOrDefault(s.charAt(right), 0) + 1);
            maxFreq = Math.max(maxFreq, freqMap.get(s.charAt(right)));

            while((right - left + 1) - maxFreq > k) {
                freqMap.put(s.charAt(left), freqMap.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }

            res = Math.max(res, right - left + 1);
        }

        return res;
        
    }
}
