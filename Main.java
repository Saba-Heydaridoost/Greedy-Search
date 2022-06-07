package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Please enter n: ");

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {          //first position of each queen: (arr[i], i)
            arr[i] = random.nextInt(n);
        }

        String board[][] = new String[n][n];
        String firstBoard[][] = new String[n][n];

        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                if (row == arr[col]) {
                    board[row][col] = "Q ";
                    firstBoard[row][col] = "Q ";
                }
                else {
                    board[row][col] = "- ";
                    firstBoard[row][col] = "- ";
                }
            }
        }

        boardOut(board);

        board = Greedy.greedy(n , board);

        int lastH = Functions.heuristicFunction(n, board);

        if (lastH == 0) {
            System.out.println("This is the solution: ");
            boardOut(board);
        }
        else {
            System.out.println("The Greedy Algorithm Failed!");
        }
    }

    public static void boardOut(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
