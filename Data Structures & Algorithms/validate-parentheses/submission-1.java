class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for(Character c: s.toCharArray()) {
            if(!stack.isEmpty() && ((c == ']' && stack.peek() == '[') ||
            (c == '}' && stack.peek() == '{') ||
            (c == ')' && stack.peek() == '('))) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}
