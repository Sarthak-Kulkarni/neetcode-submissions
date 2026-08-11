class Solution {
    private void makePermute(List<List<Integer>> res, List<Integer> comb, int[] nums) {
        if(comb.size() == nums.length) {
            res.add(new ArrayList<>(comb));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(comb.contains(nums[i])) {
                continue;
            }
            comb.add(nums[i]);
            makePermute(res, comb, nums);
            comb.remove(comb.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        makePermute(res, new ArrayList<>(), nums);
        return res;
    }
}
