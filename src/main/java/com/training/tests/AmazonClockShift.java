package com.training.tests;

public class AmazonClockShift {

    public static void main(String[] args) {
        int[][] clock = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        print(clock);
        clock = shiftON(clock);

        System.out.println("");
        print(clock);

    }

    private static int[][] shiftON(int clock[][]) {
        int x = 0, y = 1;
        int current = clock[x][y];
        while (x != 0 || y != 0) {

            if (x == 0 && y < clock[x].length - 1) {
                y++;
            } else if (y == clock[x].length - 1 && x < clock.length - 1) {
                x++;
            } else if (x == clock.length - 1 && y > 0) {
                y--;
            } else if (y == 0 && x > 0) {
                x--;
            }
            int next = clock[x][y];
            clock[x][y] = current;
            current = next;
        }
        clock[0][1] = current;

        return clock;
    }

    private static int[][] shiftNSq2(int clock[][]) {
        int shifted[][] = new int[clock.length][clock[0].length];
        for (int i = 0; i < clock.length; i++) {
            for (int j = 0; j < clock[i].length; j++) {
                if (!(i == 0 || i == clock.length - 1 || j == 0 || j == clock[i].length - 1)) {
                    shifted[i][j] = clock[i][j];
                    continue;
                }
                int ni = i;
                int nj = j;
                if (i == 0 && j < clock[i].length - 1) {
                    nj++;
                } else if (j == clock[i].length - 1 && i < clock.length - 1) {
                    ni++;
                } else if (i == clock.length - 1 && j > 0) {
                    nj--;
                } else if (j == 0 && i > 0) {
                    ni--;
                }

                shifted[ni][nj] = clock[i][j];
            }
        }
        return shifted;
    }

    private static void print(int[][] array) {
        for (int[] rows : array) {
            for (int column : rows) {
                System.out.print(column + " ");
            }
            System.out.println("");
        }
    }
}
