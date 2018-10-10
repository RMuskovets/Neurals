package org.roman.neurals;

/**
 * @author Roman Myskovets'
*/

public class Range {
    
    /**
     * Create an array that contains values in range from start to end.
     * @param start The start of count.
     * @param end The end of count.
     * @param step The step.
     * @returns The array.
    */

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
