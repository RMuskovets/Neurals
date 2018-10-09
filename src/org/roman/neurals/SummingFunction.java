package org.roman.neurals;

public class SummingFunction {
	public double sum(double... in) {
		double res = 0;
		for (double d:in) res += d;
		return res;
	}
}
