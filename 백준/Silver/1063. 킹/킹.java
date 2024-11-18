import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static char[] king, rock;
	static int n;

	public static void main(String args[]) throws IOException {
	    BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    StringTokenizer stk = new StringTokenizer(bfr.readLine()," ");
	    
	    king = stk.nextToken().toCharArray(); 
	    rock = stk.nextToken().toCharArray(); 
	    n = Integer.parseInt(stk.nextToken());
	    
	    for(int i = 0; i < n; i++) {
	        String cmd = bfr.readLine();
	        char[] next_king = move(cmd, king);
	        if(isInRange(next_king)) { // 킹 움직였더니 일단 범위 안에는 있음
	            if(next_king[0] == rock[0] && next_king[1] == rock[1]) { // 킹 움직였더니 돌이랑 겹치면
	                char[] next_rock = move(cmd, rock);
	                if(isInRange(next_rock)) { // 움직인 돌도 범위 안에 있으면
	                    king = next_king;
	                    rock = next_rock;
	                } else {
	                    continue; // 돌이 범위 밖으로 나가면 이번 명령 무시
	                }
	            } else { // 킹 움직였더니 돌이랑 겹치진 않으면 킹만 움직이면 됨
	                king = next_king;
	            }
	        } else {
	            continue; // 킹 움직였더니 범위 밖으로 나가면 명령 무시
	        }
	    }

	    sb.append(king[0]).append(king[1]).append("\n");
	    sb.append(rock[0]).append(rock[1]);
	    System.out.println(sb);
	}

	static Boolean isInRange(char[] a) {
	    if(a[0] < 'A' || a[0] > 'H' || a[1] < '1' || a[1] > '8') return false;
	    else return true;
	}

	static char[] move(String cmd, char[] target) {
	    char[] result = target.clone();
	    switch(cmd) {
	        case "R":
	            result[0]++;
	            break;
	        case "L":
	            result[0]--;
	            break;
	        case "B":
	            result[1]--;
	            break;
	        case "T":
	            result[1]++;
	            break;
	        case "RT":
	            result[0]++;    result[1]++;
	            break;
	        case "LT":
	            result[0]--;    result[1]++;
	            break;
	        case "RB":
	            result[0]++;    result[1]--;
	            break;
	        case "LB":
	            result[0]--;    result[1]--;
	    }
	    return result;
	}

}
