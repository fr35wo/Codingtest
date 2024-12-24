import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int m = 0; m < commands.length; m++) {
            int i = commands[m][0]; // 시작 인덱스 (1-based index)
            int j = commands[m][1]; // 끝 인덱스 (1-based index)
            int k = commands[m][2]; // k번째 값

            // 복사할 배열의 길이 계산
            int length = j - (i - 1);
            int[] newArr = new int[length];

            // System.arraycopy()를 사용하여 범위 복사
            System.arraycopy(array, i - 1, newArr, 0, length);

            // 복사된 배열 정렬
            Arrays.sort(newArr);

            // k번째 값 저장
            answer[m] = newArr[k - 1];
        }

        return answer;
    }
}
