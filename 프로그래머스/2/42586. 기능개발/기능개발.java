import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> proQueue = new ArrayDeque<>();
        Queue<Integer> speedQueue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            proQueue.add(progresses[i]);
            speedQueue.add(speeds[i]);
        }

        while (!proQueue.isEmpty()) {
            // 하루 동안 작업 진행
            for (int i = 0, size = proQueue.size(); i < size; i++) {
                proQueue.add(proQueue.poll() + speedQueue.peek()); // 작업 진행도 업데이트
                speedQueue.add(speedQueue.poll());                // 속도는 다시 추가
            }

            int count = 0;
            while (!proQueue.isEmpty() && proQueue.peek() >= 100) {
                proQueue.poll(); // 작업 배포
                speedQueue.poll();
                count++;
            }

            if (count > 0) {
                result.add(count);
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
