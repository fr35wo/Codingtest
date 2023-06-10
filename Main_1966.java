package bak;
import java.util.Scanner;
import java.util.Arrays;
import java.util.LinkedList; //import
import java.util.Queue; //import

//못품
public class Main_1966 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        int test = input.nextInt(); // 테스트 케이스

        for (int i = 0; i < test; i++) {
            int a = input.nextInt(); // 문서 개수
            int b = input.nextInt(); // 몇 번째로 인쇄되었는지 궁금한 문서가 현재 큐 몇번째에 놓여있나

            Queue<Integer> queue = new LinkedList<>(); // int형 queue 선언, linkedlist 이용
            int array[] = new int[a];// 중요도 배열

            for (int j = 0; j < a; j++) {
                int c = input.nextInt();// 각각의 중요도
                array[j] = c;
                queue.offer(c);
            }

            int im = 0;

            Arrays.sort(array); // 중요도 오름차순 정렬

            for (int k = a - 1; k >= 0; k--) {// 중요도 높은 것 부터
                im = array[k];

                if (im == queue.peek()) {
                    queue.poll();
                    if (b == 0) {
                        break;
                    } else {
                        b--;
                    }
                } else {
                    queue.offer(queue.poll());
                    if (b == 0) {
                        b = queue.size() - 1;
                    } else {
                        b--;
                    }
                }
            }
            System.out.println();
            System.out.print(a - queue.size());
        }

    }
}

//import java.util.Scanner;
//import java.util.LinkedList;
// 
//public class Main {
//	public static void main(String[] args) {
//		
//		Scanner in = new Scanner(System.in);
//		StringBuilder sb = new StringBuilder();
//		
//		int T = in.nextInt();	// 테스트 케이스 
// 
//		while (T-- > 0) {
//			
//			int N = in.nextInt();
//			int M = in.nextInt();
//			
//			LinkedList<int[]> q = new LinkedList<>();	// Queue로 활용 할 연결리스트
// 
//			for (int i = 0; i < N; i++) {
//				// {초기 위치, 중요도}
//				q.offer(new int[] { i, in.nextInt() });
//			}
// 
//			int count = 0;
//			
//			while (!q.isEmpty()) {	// 한 케이스에 대한 반복문
//				
//				int[] front = q.poll();	// 가장 첫 원소
//				boolean isMax = true;	// front 원소가 가장 큰 원소인지를 판단하는 변수
//				
//				// 큐에 남아있는 원소들과 중요도를 비교 
//				for(int i = 0; i < q.size(); i++) {
//					
//					// 처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 클 경우 
//					if(front[1] < q.get(i)[1]) {
//						
//						// 뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다.
//						q.offer(front);
//						for(int j = 0; j < i; j++) {
//							q.offer(q.poll());
//						}
//						
//						// front원소가 가장 큰 원소가 아니였으므로 false를 하고 탐색을 마침
//						isMax = false;
//						break;
//					}
//				}
//				
//				// front 원소가 가장 큰 원소가 아니였으므로 다음 반복문으로 넘어감
//				if(isMax == false) {
//					continue;
//				}
//				
//				// front 원소가 가장 큰 원소였으므로 해당 원소는 출력해야하는 문서다.
//				count++;
//				if(front[0] == M) {	// 찾고자 하는 문서라면 해당 테스트케이스 종료
//					break;
//				}
// 
//			}
// 
//			sb.append(count).append('\n');
// 
//		}
//		System.out.println(sb);
//	}
// 
//}
// 
//
// 
//
//가장 기본적인 방법이라 할 수 있겠다.
//
// 
//
//앞서 말했듯이 front 값이 가장 큰 값이냐, 아니냐에 따라 출력해야 하는 원소인지 아닌지가 갈리기 때문에 isMax 변수를 두었다.
//
//아무래도 반복문이 3중이다보니 조금은 헷갈릴 수 있지만 최대한 주석으로 설명을 해놓았으니 조금만 이해보도록 하자. 이해만하면 어렵지 않다. 
//
// 
//
//그리고 큐의 경우는 중간 탐색(get()) 을 사용해야하므로 LinkedList를 사용했다. 물론, LinkedList도 Queue를 구현하기 때문에 offer, poll 같은 메소드도 사용할 수 있다. offer 대신 add, poll 대신 remove를 사용해도 무방하지만, 큐 문제인만큼 일관성있게 offer와 poll을 사용했다.