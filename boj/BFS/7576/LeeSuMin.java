package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] box;
    static Queue<Pos> q;
    static int[] dX = {1, -1, 0, 0};
    static int[] dY = {0, 0, 1, -1};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    Pos pos = new Pos(i, j, 0);
                    q.add(pos);
                }
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(max > 0 ? max : 0);
    }

    static class Pos {
        int x, y, day;

        Pos(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    private static void bfs() {
        while (!q.isEmpty()) {
            Pos p = q.poll();
            for (int i = 0; i < 4; i++) {
                int newX = p.x + dX[i];
                int newY = p.y + dY[i];
                int newD = p.day + 1;
                if (newX < 0 || newX >= N || newY < 0 || newY >= M || box[newX][newY] != 0) continue;
                Pos newP = new Pos(newX, newY, newD);
                q.add(newP);
                box[newX][newY] = 1;
                if (max < newD) {
                    max = newD;
                }
            }
        }
    }
}