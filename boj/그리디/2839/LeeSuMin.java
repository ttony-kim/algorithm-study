import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sugar = Integer.parseInt(br.readLine());

		int result = -1;
		int m = 1, n = 0;

		// 우선 순위 2
		while(m <= sugar / 3) {
			n = sugar - 3 * m;
			if(n % 5 == 0) {
				result = m + n / 5;
				break;
			}
			m++;
		}

		m = sugar / 5; n = 0;

		// 우선 순위 1
		while(m > 0) {
			n = sugar - 5 * m;
			if(n % 3 == 0) {
				result = m + n / 3;
				break;
			}
			m--;
		}
		
		System.out.println(result);
	}
}