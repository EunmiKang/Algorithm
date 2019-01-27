package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 
 * @author EunmiKang
 * [S/W 문제해결 기본] 4일차 - 괄호 짝짓기
 * ::
 * stack
 * 
 */
public class Solution_1218 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack;
		int size, result;
		String data;
		char read;
		boolean flag;
		for (int tn = 1; tn <= 10; tn++) {
			size = Integer.parseInt(br.readLine());
			data = br.readLine();
			stack = new Stack<>();
			flag = false;
			
			for (int i = 0; i < size; i++) {
				read = data.charAt(i);
				if (read == '(' || read == '[' || read == '{' || read == '<') {
					stack.push(read);
				} else { // 닫는 괄호
					if (stack.isEmpty()) {
						flag = true;
						break;
					}
					char top = stack.pop();
					switch(read) {
					case ')':
						if(top != '(') {
							flag = true;
						}
						break;
					case ']':
						if(top != '[') {
							flag = true;
						}
						break;
					case '}':
						if(top != '{') {
							flag = true;
						}
						break;
					case '>':
						if(top != '<') {
							flag = true;
						}
					}
					if(flag) {
						break;
					}
				}
			}

			/* 유효성 체크 */
			if (!flag) {
				if (stack.isEmpty()) {
					result = 1;
				} else {
					result = 0;
				}
			} else {
				result = 0;
			}
			
			System.out.println("#" + tn + " " + result);
		}
		br.close();
	}
}
