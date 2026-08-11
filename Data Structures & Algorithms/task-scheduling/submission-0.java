class Solution {
    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> freq = new HashMap<>();

        for(char task: tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        heap.addAll(freq.values());
        int intervals = 0;

        while(!heap.isEmpty() || !q.isEmpty()) {
            intervals++;

            if(!heap.isEmpty()) {
                int currentFreq = heap.poll();
                if(currentFreq > 1) {
                    q.offer(new Pair(currentFreq - 1, intervals + n));
                }
            }

            if(!q.isEmpty()) {
                if(q.peek().getValue() == intervals) {
                    heap.offer(q.poll().getKey());
                }
            }
        }

        return intervals;
        
    }
}
