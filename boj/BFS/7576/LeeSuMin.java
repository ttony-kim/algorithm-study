package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        boolean isNothingToRotten = true;

        for (int i = 0; i < N; i++) {
            int[] line = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j ++) {
                line[j] = Integer.parseInt(st.nextToken());
                if(line[j] == 0 && isNothingToRotten) {
                    isNothingToRotten = false;
                }
            }
            map[i] = line;
        }

        if(isNothingToRotten) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i < N; i++) {
            for(int j = 0; j< M; j++) {
                if (map[i][j] == 1) {
                    bfs(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                //System.out.print(map[i][j]);
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
            //  System.out.println();
        }

        System.out.println(totalDay);
    }

    static class Pos {
        int x, y, day;
        Pos (int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static int M, N;
    static int[][] map;
    static int totalDay;
    static int[] dX = { 1, -1, 0, 0 };
    static int[] dY = { 0, 0, 1, -1 };

    private static void bfs (int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        Pos pos = new Pos(x, y, 0);
        q.add(pos);
        while (!q.isEmpty()) {
            Pos p = q.poll();
            //System.out.println("polled P : " + p.x + " , " + p.y);
            for (int i=0; i<4; i++) {
                int newX = p.x + dX[i];
                int newY = p.y + dY[i];
                int newD = p.day + 1;
                if (newX < 0 || newX >= N || newY < 0 || newY >= M || map[newX][newY] != 0) continue;
                Pos newP = new Pos(newX, newY, newD);
                q.add(newP);
                //System.out.println("new pos push!" + "newX: " + newX + " , newY : " + newY + ", newday: " + newD);
                map[newX][newY] = newD;
                totalDay = Math.max(totalDay, newD);
            }
            //System.out.println();
        }
    }
}