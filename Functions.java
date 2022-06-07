package com.company;

public class Functions {
    public static int heuristicFunction(int n, String board[][]) {
        int h = 0;

        for (int row = 0; row < n; row++) {           //attacks on a row
            int moreThanOne = 0;
            for (int col = 0; col < n; col++) {
                if (board[row][col].equals("Q ")) {
                    moreThanOne++;
                }
            }
            if (moreThanOne > 1) {
                h += moreThanOne * (moreThanOne - 1) / 2;
            }
        }

        for (int col = 0; col < n; col++) {           //attacks on a column
            int moreThanOne = 0;
            for (int row = 0; row < n; row++) {
                if (board[row][col].equals("Q ")) {
                    moreThanOne++;
                }
            }
            if (moreThanOne > 1) {
                h += moreThanOne * (moreThanOne - 1) / 2;
            }
        }

        for (int col = 0; col < n; col++) {                 //diagonal attacks                ////
            int moreThanOne = 0;                                                              ///
            for (int row = 0, colCol = col; row <= col && colCol >= 0; row++, colCol--) {     //
                if (board[row][colCol] == "Q ") {                                     //      /
                    moreThanOne++;
                }
            }
            if (moreThanOne > 1) {
                h += moreThanOne * (moreThanOne - 1) / 2;
            }
        }

        for (int col = 0; col < n; col++) {                 //diagonal attacks                        \\\\
            int moreThanOne = 0;                            //                                          \\\
            for (int row = 0, colCol = col; row <= (n - 1 - col) && colCol < n; row++, colCol++) {   //   \\
                if (board[row][colCol] == "Q ") {                                                    //     \
                    moreThanOne++;
                }
            }
            if (moreThanOne > 1) {
                h += moreThanOne * (moreThanOne - 1) / 2;
            }
        }

        for (int col = 0; col < n - 1; col++) {                 //diagonal attacks                       \
            int moreThanOne = 0;                            //                                            \\
            for (int row = n - 1, colCol = col; row >= (n - 1 - col) && colCol >= 0; row--, colCol--) {//  \\\
                if (board[row][colCol] == "Q ") {            //                                             \\\\
                    moreThanOne++;
                }
            }
            if (moreThanOne > 1) {
                h += moreThanOne * (moreThanOne - 1) / 2;
            }
        }

        for (int col = 1; col < n; col++) {                 //diagonal attacks                      /
            int moreThanOne = 0;                            //                                    //
            for (int row = n - 1, colCol = col; row >= col && colCol < n; row--, colCol++) {//  ///
                if (board[row][colCol] == "Q ") {                                      //     ////
                    moreThanOne++;
                }
            }
            if (moreThanOne > 1) {
                h += moreThanOne * (moreThanOne - 1) / 2;
            }
        }
        return h;
    }

    public static int gFunction (int index, int row) {
        int g = Math.abs(index - row);

        return g;
    }
}
