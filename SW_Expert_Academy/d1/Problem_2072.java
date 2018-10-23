package d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2072 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=1; i<=T; i++) {
			String[] numbers = br.readLine().split(" ");
			int sum = 0;
			for(int j=0; j<10; j++) {
				if(Integer.parseInt(numbers[j]) % 2 == 1) {
					sum += Integer.parseInt(numbers[j]);
				}
			}
			System.out.println("#" + i + " " + sum);
		}
		br.close();
	}
}
