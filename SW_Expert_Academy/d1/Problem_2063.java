package d1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 중간값 찾기 */

public class Problem_2063 {
	final int MAX_N = 199;
	
	public static int[] quickSort(int[] array, int first, int last) {
		if (first < last) {
			int boundary = partition(array, first, last);
			quickSort(array, first, boundary - 1);
			quickSort(array, boundary + 1, last);
		}
		return array;
	}

	public static int partition(int[] array, int first, int last) {
		int pivot = array[last], pivot_index = last;
		int i = first - 1, j = first;
		for (; j <= last - 1; j++) {
			if (array[j] <= pivot) { // i를 1 증가시키고, A[i] <-> A[j]
				i++;
				swap(array, i, j);
			}
		}

		i++;
		swap(array, i, pivot_index); // A[i] <-> pivot

		return i;
	}
	
	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] scores = new int[N];
		String[] read_scores = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			scores[i] = Integer.parseInt(read_scores[i]);
		}
		br.close();
		
		scores = quickSort(scores, 0, N-1);
		
		System.out.println(scores[N/2]);
	}
}
