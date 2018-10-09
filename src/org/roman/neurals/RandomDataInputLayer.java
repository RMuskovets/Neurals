package org.roman.neurals;

import java.util.Random;

public class RandomDataInputLayer extends InputLayer {
	public RandomDataInputLayer(int len) {
		super(getData(len));
	}
	
	private static double[] getData(int len) {
		Random rand = new Random();
		double d[] = new double[len];
		for (int i = 0; i < len; i++)
			d[i] = round(rand.nextDouble());
		return d;
	}
	
	private static double round(double d) {
		int i = (int) (d * 100);
		return (i >= 45) ? 1 : 0;
	}
}
