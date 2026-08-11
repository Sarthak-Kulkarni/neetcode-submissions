class Solution {
    private void combSum(List<List<Integer>> res, List<Integer> comb, int[] nums, int start, int remain) {
        if(remain < 0) {
            return;
        }

        if(remain == 0) {
            res.add(new ArrayList<>(comb));
        }

        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i-1]) {
                continue;
            }
            comb.add(nums[i]);
            combSum(res, comb, nums, i + 1, remain - nums[i]);
            comb.remove(comb.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();

        combSum(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }
}
