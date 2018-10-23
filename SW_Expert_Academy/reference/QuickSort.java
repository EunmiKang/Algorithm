package reference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSort {
	
	public QuickSort() {
		
	}
	
	public int[] quickSort(int[] array, int first, int last) {
		if (first < last) {
			int boundary = partition(array, first, last);
			quickSort(array, first, boundary - 1);
			quickSort(array, boundary + 1, last);
		}
		return array;
	}

	public int partition(int[] array, int first, int last) {
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
	
	public void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		for (int i = 1; i <= T; i++) {
			int N = Integer.parseInt(br.readLine()); // 데이터 크기
			String[] values = br.readLine().split(" ");
			int[] array = new int[N];
			for (int j = 0; j < N; j++) {
				array[j] = Integer.parseInt(values[j]);
			}
			QuickSort quickSort = new QuickSort();
			array = quickSort.quickSort(array, 0, N-1);
			for(int j=0; j<N; j++) {
				System.out.print(array[j] + " ");
			}
			System.out.println();
		}
	}
}
