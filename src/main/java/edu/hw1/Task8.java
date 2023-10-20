package edu.hw1;

public class Task8 {
    private static final int BOARD_SIZE = 8;
    private static final int[] HEAT_X = {2, 2, -2, -2, 1, -1, 1, -1};
    private static final int[] HEAT_Y = {1, -1, 1, -1, 2, 2, -2, -2};

    private Task8() {
    }

    public static boolean knightBoardCapture(int[][] board) {
        if (!isValidBoard(board)) {
            return false;
        }
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board.length; ++j) {
                if (board[j][i] == 1 && isAttacked(board, j, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isAttacked(int[][] board, int x, int y) {
        for (int i = 0; i < HEAT_X.length; ++i) {
            if (isValidCell(x + HEAT_X[i], y + HEAT_Y[i]) && board[x + HEAT_X[i]][y + HEAT_Y[i]] == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidCell(int x, int y) {
        return  (x > 0 && x < BOARD_SIZE) && y > 0 && y < BOARD_SIZE;
    }

    private static boolean isValidBoard(int[][] board) {
        if (board.length != BOARD_SIZE) {
            return false;
        }
        for (int[] s : board) {
            if (s.length != BOARD_SIZE) {
                return false;
            }
        }
        return true;
    }
}
