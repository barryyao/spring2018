package hw2;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private int T;
    private double[] percolatedRates;

    public PercolationStats(int N, int T, PercolationFactory pf) {
        // perform T independent experiments on an N-by-N grid
        if (N <= 0 || T <= 0) {
            throw new IllegalArgumentException();
        }
        this.T = T;
        percolatedRates = new double[T];
        int[] sites = new int[N * N];
        for (int j = 0; j < sites.length; j++) {
            sites[j] = j;
        }
        for (int i = 0; i < percolatedRates.length; i++) {
            Percolation percolation = pf.make(N);
            StdRandom.shuffle(sites);
            int openSiteNum = 0;
            for (int i1 = 0; i1 < sites.length && !percolation.percolates(); i1++) {
                percolation.open(sites[i1] / N, sites[i1] % N);
                openSiteNum++;
            }
            percolatedRates[i] = (double) openSiteNum / (N * N);
        }
    }
    public double mean()  {
        // sample mean of percolation threshold
        return StdStats.mean(percolatedRates);
    }
    public double stddev() {
        // sample standard deviation of percolation threshold
        return StdStats.stddev(percolatedRates);
    }
    public double confidenceLow() {
        // low endpoint of 95% confidence interval
        return mean() - 1.96 * stddev() / Math.sqrt(T);
    }
    public double confidenceHigh() {
        // high endpoint of 95% confidence interval
        return mean() + 1.96 * stddev() / Math.sqrt(T);
    }

    public static void main(String[] args) {
        PercolationStats percolationStats = new PercolationStats(100,
                100, new PercolationFactory());
        double mean = percolationStats.mean();
        System.out.println("mean: " + mean);
        double stddev = percolationStats.stddev();
        System.out.println("stddev: " + stddev);
        double confidenceLow = percolationStats.confidenceLow();
        System.out.println("confidenceLow: " + confidenceLow);
        double confidenceHigh = percolationStats.confidenceHigh();
        System.out.println("confidenceHigh: " + confidenceHigh);

    }

}
