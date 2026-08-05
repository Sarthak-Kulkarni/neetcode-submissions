class Solution {
    public int maxArea(int[] heights) {

        int maxArea = 0, start = 0, end = heights.length - 1;

        while(start < end) {
            maxArea = Math.max(maxArea, (end-start) * Math.min(heights[start], heights[end]));
            if(heights[start] <= heights[end]) {
                start++;
            } else {
                end--;
            }
        }
        return maxArea;
    }
}
