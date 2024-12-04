import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> deque = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            deque.push(s.charAt(i));
        }
        
        int count = 0;
        
        while (!deque.isEmpty()) {
            char current = deque.pop();
            if (current == ')') {
                count++;
            } else if (current == '(' && count >= 1) {
                count--;
            } else {
            	answer = false;
            }
        }
        
        if (count != 0) {
            answer = false;
        }

        return answer;
    }
}
