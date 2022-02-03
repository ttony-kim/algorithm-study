class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        int tempN = -1;
        while(n > 0){
            tempN = n % 3;
            if(tempN == 0)
                sb.append("4");
            else if(tempN == 1)
                sb.append("1");
            else if(tempN == 2)
                sb.append("2");
            // tempN == 0일 때 n-1 해줘야 한다는데 모르겠음 이거 때문에 통과 못 함
            n = n / 3;
        }

        return sb.reverse().toString();
    }
}