class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        String[] num = {"4", "1", "2"};

        int tempN = -1;
        while(n > 0){
            tempN = n % 3;
            sb.append(num[tempN]);
            n = tempN == 0 ? (n-1) / 3 : n / 3;
        }

        return sb.reverse().toString();
    }
}