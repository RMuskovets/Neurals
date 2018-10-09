package org.roman.neurals;

public class InputLayer {
	private double[] inputs;
	
	public InputLayer(double[] inputs) {
		this.inputs = inputs;
	}
	
	public double get(int inputID) {
		return inputs[inputID];
	}
	
	public double[] get() {
		return inputs;
	}
}
