import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>(); // 다리 위의 트럭
        int time = 0; // 경과 시간
        int current_weight = 0; // 다리 위에 있는 트럭들의 총 무게
        int idx = 0; // 대기 중인 트럭의 인덱스

        // 다리 위의 트럭은 다리 길이에 맞게 초기화
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0); // 초기에는 다리 위가 비어있으므로 0으로 채운다
        }

        while (idx < truck_weights.length) {
            // 1초 경과
            time++;

            // 다리 위에서 트럭이 지나감
            current_weight -= bridge.poll(); // 다리에서 지나간 트럭의 무게를 빼기
            // 새로운 트럭이 올라갈 수 있으면 다리 위에 올리기
            if (current_weight + truck_weights[idx] <= weight) {
                bridge.add(truck_weights[idx]);
                current_weight += truck_weights[idx];
                idx++; // 트럭이 다리에 올라갔으므로 대기 트럭 인덱스 증가
            } else {
                bridge.add(0); // 트럭이 올라가지 못하면 빈 공간을 넣는다
            }
        }

        // 모든 트럭이 지나가려면 다리 길이만큼 추가 시간이 걸린다
        return time + bridge_length;
    }
}
