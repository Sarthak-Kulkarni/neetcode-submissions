class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] > 0) {
                break;
            } else if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            } else {
                int start = i + 1, end = nums.length - 1;

                while(start < end) {
                    int currSum = nums[i] + nums[start] + nums[end];

                    if(currSum > 0) {
                        end--;
                    } else if(currSum < 0) {
                        start++;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        start++;
                        end--;
                        while(start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
