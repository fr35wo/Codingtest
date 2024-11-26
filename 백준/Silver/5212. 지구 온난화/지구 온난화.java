import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();

        st = new StringTokenizer(br.readLine(), " ");

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[][] map = new String[R][C];
        String[][] newMap = new String[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = String.valueOf(line.charAt(j));
                newMap[i][j] = map[i][j]; // 초기값 복사
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j].equals("X")) {
                    int count = 0; // 주변 바다의 수

      
                    for (int k = 0; k < 4; k++) {
                        int idx = i + dx[k];
                        int idy = j + dy[k];

                        // 배열 범위를 벗어나는 경우는 바다로 간주
                        if (idx < 0 || idx >= R || idy < 0 || idy >= C || map[idx][idy].equals(".")) {
                            count++;
                        }
                    }

                    // 바다가 3개 이상이면 현재 위치는 바다가 된다
                    if (count >= 3) {
                        newMap[i][j] = ".";
                    }
                }
            }
        }

        int minRow = R, minCol = C, maxRow = 0, maxCol = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (newMap[i][j].equals("X")) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minCol; j <= maxCol; j++) {
                sb.append(newMap[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
