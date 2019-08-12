package com.willlee.leetcode.array;

public class GameOfLife {

    public void gameOfLife1(int[][] board) {
        int rowLen = board.length;
        if (rowLen == 0) {
            return;
        }
        int columnLen = board[0].length;
        // 记录周围1的个数
        int count = 0;
        for (int row = 0; row < rowLen; row++) {
            for (int column = 0; column < columnLen; column++) {
                count = 0;
                int i = (row > 0 ? (row - 1) : 0);
                while (i < rowLen && i <= row + 1) {
                    int j = (column > 0 ? (column - 1) : 0);
                    while (j < columnLen && j <= column + 1) {
                        if (board[i][j] == 1 || board[i][j] == -2) {
                            count++;
                        }
                        j++;
                    }
                    i++;
                }
                // 因为之前遍历的时候会把当前结点也算上,所以如果原是活细胞的话，会多一个1
                if (board[row][column] == 1 && (count != 3 && count != 4)) {
                    board[row][column] = -2;
                }
                if (board[row][column] == 0 && count == 3) {
                    board[row][column] = -1;
                }
            }
        }
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < columnLen; j++) {
                if (board[i][j] < 0) {
                    board[i][j] += 2;
                }
            }
        }
    }

    public static void gameOfLife(int[][] board) {
        int[][] boardOld = new int[board.length][board[0].length];
        // 复制一个数组，记录数组的当前状态
        for (int i = 0; i < boardOld.length; i++) {
            for (int j = 0; j < boardOld[0].length; j++) {
                boardOld[i][j] = board[i][j];
            }
        }

        // 对数组进行更新
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = update(boardOld, i, j);
            }
        }
    }

    public static int update(int[][] board, int x, int y) {
        int currentCellStauts = board[x][y];// 读取当前细胞状态，时的还是活的
        int liveCellsArountCurrentCell = countAlive(board, x, y);// 当前细胞周围活细胞数量
        // 根据游戏规则，返回相应的值
        // 活细胞
        if (currentCellStauts == 1) {
            if (liveCellsArountCurrentCell < 2)
                return 0;
            else if (liveCellsArountCurrentCell == 2 || liveCellsArountCurrentCell == 3)
                return 1;
            else {
                return 0;
            }
        } else {
            if (liveCellsArountCurrentCell == 3)
                return 1;
            else
                return 0;
        }
    }

    /**
     * 当前细胞周围活的细胞数量
     */
    public static int countAlive(int[][] board, int x, int y) {
        return isAlive(x - 1, y - 1, board) + isAlive(x - 1, y, board) + isAlive(x - 1, y + 1, board)
                + isAlive(x, y - 1, board) + isAlive(x, y + 1, board) + isAlive(x + 1, y - 1, board)
                + isAlive(x + 1, y, board) + isAlive(x + 1, y + 1, board);
    }

    /**
     * 返回board[x][y]是否存活，越界返回0，视为死亡
     */
    private static int isAlive(int x, int y, int[][] board) {
        int m = board.length - 1, n = board[0].length - 1;
        if (x < 0 || x > m)
            return 0;
        if (y < 0 || y > n)
            return 0;
        return board[x][y];
    }
}
