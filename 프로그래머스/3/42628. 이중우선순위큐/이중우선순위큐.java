import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> reverse_pq = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            String[] temp = operation.split(" ");
            String command = temp[0];
            int value = Integer.parseInt(temp[1]);

            if (command.equals("I")) {
                pq.add(value);
                reverse_pq.add(value);
            } else if (command.equals("D")) {
                if (!pq.isEmpty()) {
                    if (value == 1) { // 최댓값 삭제
                        int max = reverse_pq.poll();
                        pq.remove(max);
                    } else { // 최솟값 삭제
                        int min = pq.poll();
                        reverse_pq.remove(min);
                    }
                }
            }
        }

        // 큐가 비어 있지 않을 경우 최댓값과 최솟값 반환
        if (!pq.isEmpty()) {
            answer[0] = reverse_pq.peek(); 
            answer[1] = pq.peek();         
        }

        return answer;
    }
}
