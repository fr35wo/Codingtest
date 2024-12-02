import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> queue = new ArrayDeque<>();
        
        for(int i=0; i<arr.length; i++) {
        	if (queue.peekLast() == null || queue.peekLast() != arr[i]) {
                queue.add(arr[i]);
            }
        }
        
        int[] answer = new int[queue.size()];
        
        int idx = 0;
        while (!queue.isEmpty()) {
            answer[idx++] = queue.removeFirst();
        }
       
        return answer;
    }
}
