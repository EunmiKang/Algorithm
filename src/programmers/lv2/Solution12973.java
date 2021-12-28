package programmers.lv2;

/**
 * 
 * @author 
 * EunmiKang 
 * Lv2.짝지어 제거하기
 * :: 
 * stack
[입력 예제] 
s=baabaa
s=cdcd
 */

import java.util.Stack;

class Solution12973 {
	public int solution(String s)
    {
        int answer = 0;
        
        int s_len = s.length();
        
        if(answer % 2 != 0) {
            return answer;
        }
        
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s_len; i++) {
            char item = s.charAt(i);
            if(stack.size() == 0) {
                stack.push(item);
            } else {
                if(stack.peek() == item) {
                    stack.pop();
                } else {
                    stack.push(item);
                }
            }
        }
        
        if(stack.size() == 0) {
            answer = 1;
        }
        
        return answer;
    }
}
