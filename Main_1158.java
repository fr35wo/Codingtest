package bak;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main_1158 {
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt(); // 명 수
		int k = input.nextInt(); // 제거 번째 수

		List<Integer> people = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			people.add(i);
		}

		int index = 0;
		List<Integer> result = new ArrayList<>();

		while (!people.isEmpty()) {
			index = (index + k - 1) % people.size();
			result.add(people.get(index));
			people.remove(index);
		}

		System.out.print("<");
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
			if (i != result.size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.print(">");
	}
}

//List list = new ArrayList();
//-> 도형 list = new 정사각형();
//
//ArrayList list = new ArrayList();
//-> 정사각형 list = new 정사각형();

//유연성: List 인터페이스를 사용하면 다양한 리스트 구현체를 사용할 수 있다. 
//ArrayList는 그 중 하나로, 가변 크기 배열을 기반으로 한 구현체다. 
//이렇게 List 인터페이스를 사용하면 코드의 유연성이 높아지고, 
//추후에 다른 리스트 구현체로 변경해야 할 경우에도 코드 수정이 쉬워진다.

//편의성: ArrayList는 크기를 동적으로 조정할 수 있는 배열을 사용하기 때문에 요소를 쉽게 추가하고 제거할 수 있다.
//기존 배열의 크기를 고정하는 일반적인 배열과는 달리, ArrayList는 자동으로 크기를 조절하여 필요에 따라 메모리를 재할당한다. 
//이를 통해 사람들의 명 수가 변경되더라도 코드 수정 없이도 처리할 수 있다.

//처음에 큐를 떠올렸지만 

//1 1부터 n까지의 숫자를 큐에 넣은 후,
//2 큐의 첫번째 원소부터 k-1번째 숫자를 큐에서 빼고 맨 뒤에 추가한다. ---이 부분을 생각해내지 못하여 다른 방법 으로 구현했다.
//3 k번째인 원소는 아예 큐에서 제거해버린다.
//4 이렇게 큐에 남아있는 원소가 1이 아닐때까지 반복하고, 큐에 남아있는 마지막 원소는 그냥 poll하기만 하면 된다.