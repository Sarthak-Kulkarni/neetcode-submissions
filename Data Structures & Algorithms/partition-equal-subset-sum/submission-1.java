class Solution {
    public boolean canPartition(int[] nums) {

        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        if(sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for(int i = n-1; i >= 0; i--) {
            Set<Integer> newDp = new HashSet<>();
            for(int t: dp) {
                if(t + nums[i] == target) {
                    return true;
                }

                newDp.add(nums[i] + t);
                newDp.add(t);
            }
            dp = newDp;
        }
        
        return false;
    }
}
