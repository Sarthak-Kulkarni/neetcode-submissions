class Solution {
    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>();
        for(String str: tokens) {
            if("+".equals(str)) {
                stack.push(stack.pop() + stack.pop());
            } else if("-".equals(str)) {
                int a = stack.pop(), b = stack.pop();
                stack.push(b - a);
            } else if("*".equals(str)) {
                stack.push(stack.pop() * stack.pop());
            } else if("/".equals(str)) {
                int a = stack.pop(), b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        
        return stack.pop();
    }
}
