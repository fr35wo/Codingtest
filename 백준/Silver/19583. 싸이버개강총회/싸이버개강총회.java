import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String S = st.nextToken(); // 총회 시작 시간
        String E = st.nextToken(); // 총회 끝낸 시간
        String Q = st.nextToken(); // 스트리밍 끝낸 시간

        //00:00 ~ S, E ~ Q 두 구간에 모두 포함된  사람의 수를 세는 것
        
        Set<String> before = new HashSet<>();
        Set<String> after = new HashSet<>();
        Set<String> nameSet = new HashSet<>();
        
        String str = null;
        
        while((str = br.readLine()) != null) {
            String[] arr = str.split(" ");
            String time = arr[0];
            String name = arr[1];

            nameSet.add(name);
            if(S.compareTo(time) >= 0) { // S가 time보다 클 때
                before.add(name);
            }else if(E.compareTo(time) <= 0 && Q.compareTo(time) >= 0) {
                after.add(name);
            }
        }

        int ans = 0;
        for(String name : nameSet) {
            if(before.contains(name) && after.contains(name)) {
                ans += 1;
            }
        }
        
        System.out.println(ans);
    
    }
}
