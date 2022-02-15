import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int count;
		for (int i = 0; i < n; i++) {
			count = 0;
			String line = br.readLine();
			for (int j = 0, len = line.length(); j < len; j++) {
				if (line.charAt(j) == '(')
					count++;
				else
					count--;

				if (count < 0) 
					break;				
			}

			sb.append(count == 0 ? "YES\n" : "NO\n");
		}

		System.out.print(sb);
	}
}