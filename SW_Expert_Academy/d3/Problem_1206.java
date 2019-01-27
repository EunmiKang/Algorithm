package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @author EunmiKang
 * 1206. [S/W 문제해결 기본] 1일차 - View
 *
 */
public class Problem_1206 {
	public static void main(String[] args) throws IOException {
		//BufferedReader br = new BufferedReader(new FileReader("input_1206.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int T = 1;
		while (line != null) {
			int size = Integer.parseInt(line);
			String[] read_building_sizes = br.readLine().split(" ");
			int[] building_sizes = new int[size];
			int household_count = 0;
			for(int i=0; i<size; i++) {
				building_sizes[i] = Integer.parseInt(read_building_sizes[i]);
			}
			
			int[] plus = {-2, -1, 1, 2};
			for(int i=2; i<size-2; i++) {
				if(building_sizes[i] != 0) {
					int curr_household = building_sizes[i];
					for(int j=0; j<4; j++) {
						int curr_count = building_sizes[i] - building_sizes[i+plus[j]];
						if(curr_count > 0) {
							if(curr_count < curr_household) {
								curr_household = curr_count;
							}
						} else {
							curr_household = 0;
							break;
						}
					}
					household_count += curr_household;
				}	
			}
			
			System.out.println("#" + T + " " + household_count);
			
			T++;
			line = br.readLine();
		}
		br.close();
	}
}
