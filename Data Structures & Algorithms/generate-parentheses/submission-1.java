class Solution {

    private void generate(List<String> res, int left, int right, int n, String s) {
        if(s.length() == 2*n) {
            res.add(s);
        } else {
            if(left < n) {
                generate(res, left + 1, right, n, s + '(');
            }

            if(right < left) {
                generate(res, left, right + 1, n, s + ')');
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, 0, 0, n, "");
        return res;
    }
}
