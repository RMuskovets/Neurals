package org.roman.neurals;

/**
 * The input for a NeuralNetwork.
 * @author Roman Myskovets'
*/

public class InputLayer {
	
	/**
	 * The actual input for neural network.
	*/
	
	private double[] inputs;
	
	public InputLayer(double[] inputs) {
		this.inputs = inputs;
	}
	
	/**
	 * Get a value from inputs.
	 * @param inputID the input index
	*/
	
	public double get(int inputID) {
		return inputs[inputID];
	}
	
	/**
	 * Get all inputs in a double array.
	*/
	
	public double[] get() {
		return inputs;
	}
}
