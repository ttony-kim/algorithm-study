import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		
		// 레이저()를 X로 치환
		str = str.replaceAll("\\(\\)", "X");
		
		// X의 인덱스 저장
		int[] arr = new int[100001];
		for(int i=0, len=str.length(); i<len; i++) {
			if("X".equals(str.charAt(i) + "")) arr[i]++;
		}
		
		Stack<String> stStack = new Stack<String>();	// str 담을 스택
		Stack<Integer> idxStack = new Stack<Integer>();	// str의 인덱스를 담을 스택
		
		int barCnt = 0;	// 잘려진 막대 개수
		
		for(int i=0, len=str.length(); i<len; i++) {
			String cha = str.charAt(i) + "";
			if(!"X".equals(cha)) {		// X가 아닌 경우에만
				if(!stStack.empty()) {		
					if("()".equals(stStack.peek() + cha)) {		// 괄호가 하나의 ()면 막대 1개
						int thisBar = 1;						// 막대 기본 개수 1
						for(int j=idxStack.peek(), k=i; j<=k; j++) {
							if(arr[j] !=0 ) thisBar++;		// 막대 위에 X(레이저) 개수만큼 카운트
						}
						barCnt += thisBar;
						stStack.pop();							// 막대 완성됐으니 꺼냄
						idxStack.pop();							// 막대 완성됐으니 꺼냄
					}else {										// 하나의 ()가 될 때까지 push
						idxStack.push(i);
						stStack.push(cha);
					}
				}else {
					idxStack.push(i);
					stStack.push(cha);
				}
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(barCnt));
		
		br.close();
		bw.flush();
		bw.close();
	}
}
