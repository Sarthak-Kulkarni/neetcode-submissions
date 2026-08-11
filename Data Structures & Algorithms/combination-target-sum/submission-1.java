class Solution {

    private void combSum(List<List<Integer>> res, List<Integer> comb, int[] nums, int start, int remain) {
        if(remain < 0) {
            return;
        }

        if(remain == 0) {
            res.add(new ArrayList<>(comb));
        }

        for(int i = start; i < nums.length; i++) {
            comb.add(nums[i]);
            combSum(res, comb, nums, i, remain - nums[i]);
            comb.remove(comb.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        combSum(res, new ArrayList<>(), nums, 0, target);
        return res;
    }
}
