import java.util.Arrays;
import java.util.Scanner;
public class b1931 {
	
	private static class Meeting  {
		int startTime;
		int endTime;
		
	}
	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		Meeting[] array = new Meeting[n];
		
		for(int i = 0; i < n; i++) {
			Meeting meeting = new Meeting();
			meeting.startTime = scanner.nextInt();
			meeting.endTime = scanner.nextInt();
			array[i] = meeting;
		}
		
		Arrays.sort(array, (o1, o2) -> {
			if(o1.endTime ==  o2.endTime )
				return (o1.startTime - o2.startTime);
			else 
				return (o1.endTime - o2.endTime); 
		
		}
				);   
		
		int count=0;
		int f =0;
	
		for(int i=0;i<n;i++) {
			if(array[i].startTime>=f) {

				
				count++;
				f=array[i].endTime;}
		} 
		
		System.out.println(count);
		scanner.close();
	}
}
