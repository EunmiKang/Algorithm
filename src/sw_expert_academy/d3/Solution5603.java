package sw_expert_academy.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author EunmiKang
 * [Professional] 건초더미
 * ::
 * 컴퓨팅사고력..?
 * ::
 * 정렬해가면서 첫번째꺼랑 마지막꺼 건드는 방법으로 풀었다가 틀림!(시간초과인듯)
 * -> 아래 방법으로 바꿈
 *
 */
public class Solution5603 {
	public static int[] haystacks;	//건초더미 크기
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int N, ans, cnt;	
		for (int tn = 1; tn <= T; tn++) {
			N = Integer.parseInt(br.readLine());
			haystacks = new int[N];
			ans = 0;
			for(int i=0; i<N; i++) {
				haystacks[i] = Integer.parseInt(br.readLine());
				ans += haystacks[i];
			}
			
			//모든 건초더미들이 되어야하는 크기
			//입력으로 들어온 모든 건초더미 크기들 합을 건초더미 수만큼 나눔
			ans /= N;
			
			//(위에서 구한 ans)와 (입력으로 들어온 건초더미 크기)의 차이의 합을 구한 뒤 2로 나눈 값이 답!
			//'한' 번 움직이면 건초더미 '두' 개의 값이 변경되므로 2로 나누는 작업이 필요
			cnt = 0;
			for(int i=0; i<N; i++) {
				cnt += Math.abs(haystacks[i] - ans);
			}
			
			System.out.println("#" + tn + " " + cnt/2);
		}
		br.close();
	}
}
