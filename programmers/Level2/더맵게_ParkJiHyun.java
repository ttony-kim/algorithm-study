import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int solution(int[] scoville, int K) {
        Arrays.sort(scoville);
		PriorityQueue<Integer> underK = new PriorityQueue<Integer>();
		
		// K 이하 원소와 K다음으로 큰 값만 우선순위큐에 담음
		int sum = 0;
		for(int i=0; i<scoville.length; i++) {
			int val = scoville[i];
			if(val<=K) {
				underK.add(val);
				sum += val;
			}else {
				if(K > 0) sum += val;	
				underK.add(val);
				break;
			}
		}
			
		// 큐에 담은 값의 합이 0일 경우 {0,0,..,0}
		if(sum == 0) {
			if(K == 0) return 0;	//	K를 만들 수는 있으니까...?
			else return -1;			//	0으로는 아무것도 할 수 없어...
		}
		if(underK.size() < 2) return -1;	// 큐에 담은 값이 0~1개일 경우 계산식 성립x
		
		int calCnt = 0;		// 계산 횟수
		int min = underK.poll();	// 가장 맵지 않은
		
		if(min == K) return 0;
		
		int highest = -1;			// 초기화
		while (!underK.isEmpty()) {
			highest = min + underK.poll()*2;
			calCnt++;
			if(highest>=K) {
				break;
			}else {
				underK.add(highest);	// 다시 큐에 넣으면 최소값 계산됨
				min = underK.poll();
			}
		}
		
		if(highest < K) return -1;		// 절대 K 이상일 수 없는 경우
		
        int answer = calCnt;
        return answer;
    }
}