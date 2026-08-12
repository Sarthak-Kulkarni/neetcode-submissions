class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int[] dp1 = new int[n+2];
        int[] dp2 = new int[n+2];

        int[] nums1 = Arrays.copyOfRange(nums, 0, n-1);
        int[] nums2 = Arrays.copyOfRange(nums, 1, n);

        for(int i=nums1.length-1; i>=0; i--) {
            dp1[i] = Math.max(dp1[i+1], nums1[i] + dp1[i+2]);
        }

        for(int i=nums2.length-1; i>=0; i--) {
            dp2[i] = Math.max(dp2[i+1], nums2[i] + dp2[i+2]);
        }

        return Math.max(dp1[0], dp2[0]);
        
    }
}
