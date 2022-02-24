
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Stack<String> st = new Stack<String>();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int j=0; j<N; j++) {
			String command = br.readLine();
			for(int i=0; i<command.length(); i++) {
				if(i == 0 || st.empty()) {
					st.push(command.charAt(i)+"");
				}else {
					if((st.peek() + command.charAt(i)).equals("()")) {
						st.pop();
					}else {
						st.push(command.charAt(i)+"");
					}
				}
			}
			bw.write(st.empty() ? "YES" : "NO");
			bw.write("\n");
			st.clear();
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
