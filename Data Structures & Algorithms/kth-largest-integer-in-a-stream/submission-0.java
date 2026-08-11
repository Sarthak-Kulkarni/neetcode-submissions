class KthLargest {

    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();

        for(int i = 0; i < nums.length; i++) {
            heap.offer(nums[i]);
            if(heap.size() > k) {
                heap.poll();
            }
        }
    }
    
    public int add(int val) {
        heap.offer(val);
        if(heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}
