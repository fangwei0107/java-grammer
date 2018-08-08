package com.chinawyny.algorithm;

public class RobotMove {

    public int movingCount(int threshold, int rows, int cols) {
        boolean[] visited = new boolean[rows * cols];
        return movingCountCore(threshold, rows, cols, 0, 0, visited);
    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return 0;
        }
        int index = row * cols + col;
        if (visited[index] || !checkSum(row, col, threshold)) {
            return 0;
        }
        visited[index] = true;
        return 1 + movingCountCore(threshold, rows, cols, row + 1, col, visited)
                + movingCountCore(threshold, rows, cols, row, col + 1, visited)
                + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                + movingCountCore(threshold, rows, cols, row, col - 1, visited);
    }

    private boolean checkSum(int row, int col, int threshold) {
        int sum = 0;
        while (row > 0) {
            sum += (row % 10);
            row /= 10;
        }
        while (col > 0) {
            sum += (col % 10);
            col /= 10;
        }
        return sum <= threshold;
    }
}
