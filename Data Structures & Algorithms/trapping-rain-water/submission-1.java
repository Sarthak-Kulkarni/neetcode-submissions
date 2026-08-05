class Solution {
    public int trap(int[] height) {
        int water = 0, left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];

        while(left < right) {
            if(height[left] < height[right]) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                water += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                water += rightMax - height[right];
            }
        }

        return water;
    }
}
