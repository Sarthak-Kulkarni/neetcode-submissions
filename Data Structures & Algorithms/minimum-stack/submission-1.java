class MinStack {

    Deque<Integer> stack;

    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.pop() == min) {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return this.min;
    }
}
