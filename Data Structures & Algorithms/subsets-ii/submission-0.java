class Solution {
    private void makeSubset(List<List<Integer>> res, List<Integer> comb, int[] nums, int start) {
        res.add(new ArrayList<>(comb));
        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            comb.add(nums[i]);
            makeSubset(res, comb, nums, i+1);
            comb.remove(comb.size() - 1); 
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        makeSubset(res, new ArrayList<>(), nums, 0);
        return res;
    }
}
