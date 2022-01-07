package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int N;
    private int openSitesNO;
    private WeightedQuickUnionUF openUF;
    private int gridSize;
    private int virtualTop;
    private int[] virtualBottom;
    private boolean[] openArray;
    public Percolation(int N) {
        this.N = N;
        // create N-by-N grid, with all sites initially blocked
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        gridSize = N * (N + 1) + 1;
        openSitesNO = 0;
        virtualTop = gridSize - N - 1;
        virtualBottom = new int[N];
        for (int i = 0; i < N; i++) {
            virtualBottom[i] = gridSize - N  + i;
        }
        openUF = new WeightedQuickUnionUF(gridSize);
        openArray = new boolean[gridSize];
        for (int i = 0; i < openArray.length; i++) {
            openArray[i] = false;
        }
    }

    public void open(int row, int col) {
        // open the site (row, col) if it is not open already
        if (!checkRowAndCol(row, col)) {
            throw new IndexOutOfBoundsException();
        }
        int i = xyToIndex(row, col);
        if (!openArray[i]) {
            openArray[i] = true;
            openSitesNO++;
        }
        if (i < N) {
            openUF.union(virtualTop, i);
        }
        if (i < N * N && i >= N * (N - 1)) {
            openUF.union(virtualBottom[col], i);
        }
        checkNeedUnion(row, col);
    }

    public boolean isOpen(int row, int col) {
        // is the site (row, col) open?
        if (!checkRowAndCol(row, col)) {
            throw new IndexOutOfBoundsException();
        }
        int i = xyToIndex(row, col);
        return openArray[i];
    }

    public boolean isFull(int row, int col) {
        if (!checkRowAndCol(row, col)) {
            throw new IndexOutOfBoundsException();
        }
        // is the site (row, col) full?
        int i = xyToIndex(row, col);
        return openUF.connected(i, virtualTop);
    }

    private boolean checkRowAndCol(int row, int col) {
        return row < N && row >= 0 && col < N && col >= 0;
    }
    public int numberOfOpenSites() {
        // number of open sites
        return openSitesNO;
    }

    public boolean percolates() {
        // does the system percolate?
        for (int i = 0; i < virtualBottom.length; i++) {
            if (openUF.connected(virtualTop, virtualBottom[i])) {
                return true;
            }
        }
        return false;
    }

    private int xyToIndex(int x, int y) {
        return x * N + y;
    }

    private void checkNeedUnion(int row, int col) {
        int self = xyToIndex(row, col);
        if (row - 1 >= 0 && isOpen(row - 1, col)) {
            int up = xyToIndex(row - 1, col);
            openUF.union(up, self);
        }
        if (col - 1 >= 0 && isOpen(row, col - 1)) {
            int left = xyToIndex(row, col - 1);
            openUF.union(left, self);
        }
        if (row + 1 < N && isOpen(row + 1, col)) {
            int down = xyToIndex(row + 1, col);
            openUF.union(down, self);
        }
        if (col + 1 < N && isOpen(row, col + 1)) {
            int right = xyToIndex(row, col + 1);
            openUF.union(right, self);
        }
    }

}
