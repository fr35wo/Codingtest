import java.io.*;
import java.util.*;

public class Main {

	static int s;
	static String value;
	static char[][] result;

	public static void main(String agrs[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		s = Integer.parseInt(st.nextToken());
		int height = 2 * s + 3; // 각 숫자 찍히는 높이
		value = st.nextToken();
		int width = (s + 2) * value.length(); // 각 숫자 찍히는 너비
		result = new char[height][width + 1]; // 숫자 찍히는 배열

		for (int i = 0; i < value.length(); i++) {
			int num = Character.getNumericValue(value.charAt(i));
			LCD(num, i);
		}

		for (int i = 0; i < height; i++) {
			for (int j = 1; j <= width; j++) {
				if (result[i][j] == '-' || result[i][j] == '|')
					bw.write(result[i][j]);
				else
					bw.write(" ");
				if (j % (s + 2) == 0)
					bw.write(" ");
			}
			bw.newLine();
		}
		bw.flush(); // 결과 출력
		bw.close();
		br.close();
	}

	static void LCD(int num, int index) {
		if (num == 1) { // 숫자 1
			VerticalBar(index, 3);
			VerticalBar(index, 4);
		} else if (num == 2) { // 숫자 2
			Hyphen(index, 0);
			VerticalBar(index, 3);
			Hyphen(index, 1);
			VerticalBar(index, 2);
			Hyphen(index, 2);
		} else if (num == 3) { // 숫자 3
			Hyphen(index, 0);
			VerticalBar(index, 3);
			Hyphen(index, 1);
			VerticalBar(index, 4);
			Hyphen(index, 2);
		} else if (num == 4) { // 숫자 4
			VerticalBar(index, 1);
			VerticalBar(index, 3);
			Hyphen(index, 1);
			VerticalBar(index, 4);
		} else if (num == 5) { // 숫자 5
			Hyphen(index, 0);
			VerticalBar(index, 1);
			Hyphen(index, 1);
			VerticalBar(index, 4);
			Hyphen(index, 2);
		} else if (num == 6) { // 숫자 6
			Hyphen(index, 0);
			VerticalBar(index, 1);
			Hyphen(index, 1);
			VerticalBar(index, 2);
			VerticalBar(index, 4);
			Hyphen(index, 2);
		} else if (num == 7) { // 숫자 7
			Hyphen(index, 0);
			VerticalBar(index, 3);
			VerticalBar(index, 4);
		} else if (num == 8) { // 숫자 8
			Hyphen(index, 0);
			VerticalBar(index, 1);
			VerticalBar(index, 3);
			Hyphen(index, 1);
			VerticalBar(index, 2);
			VerticalBar(index, 4);
			Hyphen(index, 2);
		} else if (num == 9) { // 숫자 9
			Hyphen(index, 0);
			VerticalBar(index, 1);
			VerticalBar(index, 3);
			Hyphen(index, 1);
			VerticalBar(index, 4);
			Hyphen(index, 2);
		} else if (num == 0) { // 숫자 0
			Hyphen(index, 0);
			VerticalBar(index, 1);
			VerticalBar(index, 3);
			VerticalBar(index, 2);
			VerticalBar(index, 4);
			Hyphen(index, 2);
		}
		return;
	}

	// '|'(VerticalBar) s번을 1/2/3/4에 따라 찍는 함수
	static void VerticalBar(int index, int command) {
		if (command == 1 || command == 2) { // 1, 2일 때
			int col = index * (s + 2) + 1;
			int row = (command - 1) * s + command;

			for (int i = 0; i < s; i++) {
				result[row + i][col] = '|';
			}
		} else if (command == 3 || command == 4) { // 3, 4일 때
			int col = index * (s + 2) + s + 2;
			int row = (command - 3) * s + (command - 2);

			for (int i = 0; i < s; i++) {
				result[row + i][col] = '|';
			}
		}
		return;
	}

	// '-'(Hyphen) s번을 0/1/2에 따라 찍는 함수
	static void Hyphen(int index, int command) {
		int row = command * s + command;
		int col = index * (s + 2) + 2;

		for (int i = 0; i < s; i++)
			result[row][col + i] = '-';

		return;
	}

}
