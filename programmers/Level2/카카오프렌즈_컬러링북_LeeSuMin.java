class Solution {
    static int M, N;
    static int tempArea;
    static int tempSizeOfOneArea;
    static int[][] graph;
    
    public boolean dfs(int i, int j) {
        if (i < 0 || i >= M || j < 0 || j >= N) return false;
        if(graph[i][j] == 0 || graph[i][j] != tempArea) return false;

        graph[i][j] = 0;
        tempSizeOfOneArea++;

        dfs(i, j+1);
        dfs(i-1, j);
        dfs(i, j-1);
        dfs(i+1, j);

        return true;
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        M = m;
        N = n;
        // graph = picture; x
        // graph = picture.clone(); x
        // 2차 배열 복사는 1차 배열 복사랑 다름
        graph = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = picture[i][j];
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                tempSizeOfOneArea = 0;
                tempArea = graph[i][j];
                if (dfs(i, j)) {
                    numberOfArea++;
                    if (tempSizeOfOneArea > maxSizeOfOneArea)
                        maxSizeOfOneArea = tempSizeOfOneArea;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}