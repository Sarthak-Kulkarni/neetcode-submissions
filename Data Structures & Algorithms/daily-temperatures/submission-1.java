class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Deque<int[]> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int[] res = new int[n];

        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }

            stack.push(new int[]{temperatures[i], i});
        }
        
        return res;
    }
}
