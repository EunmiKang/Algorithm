package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author EunmiKang
 * 테네스의 특별한 소수
 * ::
 * D가 주어질 때 A이상 B이하의 수 중에서 특별한 소수인 것들의 개수 구하기
 * ::
 * 소수 미리 구해두기~0~
 * 
 */
public class Problem_4698 {
	static boolean[] isNotPrime;
	  
    static void checkPrime(int max) {
    	int k, tmp;
    	
    	isNotPrime = new boolean[max + 1];
    	 
    	/* 소수 체크(소수는 false) */
    	isNotPrime[0] = true;
    	isNotPrime[1] = true;
        for(int i=2; i<=1000000/2; i++) {
        	k = 2;
            while((tmp = i*k) <= 1000000) {
            	isNotPrime[tmp] = true;
                k++;
            }
        }
    }
    
    static int countSpecialPrime(int D, int A, int B) {
    	int count = 0, tmp;
    	
    	for (int i = A; i <= B; i++) {
            if(!isNotPrime[i]) {
            	tmp = i;
                while(tmp > 0) {
                	if(tmp % 10 == D) {
                		count++;
                		break;
                	}
                	tmp /= 10;
                }
            }
        }
    	
    	return count;
	}
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] line;
        int D, A, B;
        
        /* 소수 체크 */
        checkPrime(1000000);
        
        for(int tn=1; tn<=T; tn++) {
            line = br.readLine().split(" ");
            D = Integer.parseInt(line[0]);
            A = Integer.parseInt(line[1]);
            B = Integer.parseInt(line[2]);
             
            /* 소수들 보며 D가 들어가는지(특별한 소수인지) 확인 */
            int result = countSpecialPrime(D, A, B);
            
            System.out.println("#" + tn + " " + result);
        }
         
        br.close();
	}
	
}
