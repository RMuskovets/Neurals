package org.roman.neurals;

import java.io.Serializable;

public class SummingFunction implements Serializable {
	public double sum(double... in) {
		double res = 0;
		for (double d:in) res += d;
		return res;
	}
}
