import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] alphabet = new int[26];
		
		String name = br.readLine();
		
		for(int i=0; i<name.length(); i++) {
			int idx = name.charAt(i)-'A';
			alphabet[idx]++;
		}
		
		int isOne =0;
		for(int i=0; i<alphabet.length; i++) {
			if(alphabet[i]%2!=0) isOne++;
		}
		
		if(isOne>1) sb.append("I'm Sorry Hansoo");
		
		else {
			for(int i=0; i<alphabet.length; i++) {
				for(int j=0; j<alphabet[i]/2; j++) {
					sb.append((char)((i) + 'A'));
				}
			}
			
			StringBuilder end = new StringBuilder(sb);
			end.reverse();
			
			for(int i=0; i<alphabet.length; i++) {
				if(alphabet[i]%2 == 1) {
					sb.append((char)((i) + 'A'));
				}
			}
			
			sb.append(end);
		}

		System.out.println(sb);
		
	}
}
