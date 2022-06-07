package com.company;

public class Greedy {
    public static String[][] greedy(int n, String board[][]) {
        for (int col = 0; col < n; col++) {
            int hForCol[] = new int[n];

            for (int row = 0; row < n; row++) {
                for (int i = 0; i < n; i++) {
                    if (board[i][col].equals("Q ")) {
                        board[i][col] = "- ";
                    }
                }
                board[row][col] = "Q ";
                hForCol[row] = Functions.heuristicFunction(n, board);     //Calculating Heuristic Function for each row of the column.
            }

            int minH = Integer.MAX_VALUE;
            int index = 0;

            for (int row = 0; row < n; row++) {
                if (hForCol[row] < minH) {
                    minH = hForCol[row];                         //finds the least h for the queen
                    index = row;
                }
            }

            for (int i = 0; i < n; i++) {
                if (board[i][col].equals("Q ")) {
                    board[i][col] = "- ";
                }
            }
            board[index][col] = "Q ";
            System.out.println("Level " + col + ": ");
            System.out.println("The minimum value of h is " + minH + ", which happens in row " + index + ".");
            Main.boardOut(board);
        }
        return board;
    }

}
