import java.util.*;
import java.io.*;

public class Main {
	public static void main (String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] alphabet = new boolean [26];
		
		int N = Integer.parseInt(br.readLine()); // n개 옵션
		
		for(int i=0; i<N; i++) {
			String[] words = br.readLine().split(" ");
			
			boolean shortcutAssigned = false;
			
			for(int j=0; j<words.length; j++) { // 문장의 단어 수만큼
				int index = Character.toLowerCase(words[j].charAt(0)) - 'a'; //지정된 알파벳인지 알기위해 처음 알파벳 알아냄
				if(alphabet[index] == false) {
					alphabet[index] = true;
					shortcutAssigned = true;
                    words[j] = "[" + words[j].charAt(0) + "]" + words[j].substring(1); // 단축키를 표시
                    break; // 첫 번째 단어에 단축키를 지정했으므로 종료
				}
			}
			
			if(!shortcutAssigned) { // 만약 모든 단어의 첫 글자가 이미 지정이 되어있다면 왼쪽에서부터 차례대로 알파벳을 보면서 단축키로 지정 안 된 것이 있다면 단축키로 지정한다.
				
				for (int j = 0; j < words.length; j++) { 
                    for (int k = 0; k < words[j].length(); k++) {
                    	int index = Character.toLowerCase(words[j].charAt(k)) - 'a';
                    	if(alphabet[index] == false) {
        					alphabet[index] = true;
        					shortcutAssigned = true;
                            words[j] = words[j].substring(0,k) + "[" + words[j].charAt(k) + "]" + words[j].substring(k+1); // 단축키를 표시
                            break; // 첫 번째 단어에 단축키를 지정했으므로 종료
        				}
                    }
                    if (shortcutAssigned) break;
                }
				
			}

			System.out.println(String.join(" ", words));
			
		}
		
	}
}

