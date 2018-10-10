package org.roman.neurals;

public class Range {

    public static double[] range(double start, double end, double step) {
        int len = (int) ((start - end) / step);
        double[] list = new double[len];
        int c = 0;
        for (double i = start; i < start + end; i += step) {
            list[c] = i;
            c++;
        }
        return list;
    }
}
