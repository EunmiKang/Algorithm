package d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2070 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			String[] numbers = br.readLine().split(" ");
			if (Integer.parseInt(numbers[0]) > Integer.parseInt(numbers[1])) {
				System.out.println("#" + i + " >");
			} else if (Integer.parseInt(numbers[0]) < Integer.parseInt(numbers[1])) {
				System.out.println("#" + i + " <");
			} else {
				System.out.println("#" + i + " =");
			}
		}
		br.close();
	}
}
