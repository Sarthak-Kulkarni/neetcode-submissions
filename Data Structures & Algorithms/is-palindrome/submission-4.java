class Solution {

    private boolean alphaNum(char c) {
        return c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z' || c >= '0' && c <= '9'; 
    }

    public boolean isPalindrome(String s) {
        
        int start = 0, end = s.length()-1;

        while(start <= end) {
            while(start <= end && !alphaNum(s.charAt(start))) {
                start++;
            }

            while(start <= end && !alphaNum(s.charAt(end))) {
                end--;
            }

            if(start > end) {
                break;
            }

            if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
