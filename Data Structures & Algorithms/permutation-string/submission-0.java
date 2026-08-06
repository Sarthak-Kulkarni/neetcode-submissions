class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[] f1 = new int[26], f2 = new int[26];

        if(n > m) {
            return false;
        }

        for(int i = 0 ; i < n; i ++) {
            f1[s1.charAt(i) - 'a']++;
            f2[s2.charAt(i) - 'a']++;
        }

        for(int i = n; i < m; i++) {
            if(Arrays.equals(f1, f2)) {
                return true;
            }

            f2[s2.charAt(i) - 'a']++;
            f2[s2.charAt(i - n) - 'a']--;
        }

        return Arrays.equals(f1, f2);
        
    }
}
