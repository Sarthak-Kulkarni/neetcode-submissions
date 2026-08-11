class Solution {

    private void makeSubset(List<List<Integer>> res, List<Integer> comb, int[] nums, int start) {
        res.add(new ArrayList<>(comb));
        for(int i = start; i < nums.length; i++) {
            comb.add(nums[i]);
            makeSubset(res, comb, nums, i + 1);
            comb.remove(comb.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        makeSubset(res, new ArrayList<>(), nums, 0);
        return res;
    }
}
