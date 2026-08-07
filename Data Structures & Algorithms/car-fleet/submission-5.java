class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int[][] cars = new int[position.length][2];
        Deque<Double> stack = new ArrayDeque<>();

        for(int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));

        for(int[] car: cars) {
            double arrival = (target - car[0])/(double)car[1];
            
            while(!stack.isEmpty() && arrival >= stack.peek()) {
                stack.pop();
            }

            stack.push(arrival);
        }

        return stack.size();
    }
}
