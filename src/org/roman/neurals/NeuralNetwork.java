package org.roman.neurals;

import java.util.Arrays;

public class NeuralNetwork {
	private NeuronLayer[] neurons;
	private SummingFunction fn;
	
	public NeuralNetwork(SummingFunction fn, NeuronLayer[] layers) {
		this.fn = fn;
		neurons = layers;
	}
	
	public SummingFunction fn() {
		return fn;
	}
	
	public void fn(SummingFunction f) {
		fn = f;
	}
	
	public NeuronLayer[] layers() {
		return neurons;
	}
	
	public double calc(InputLayer in) {
		return calc(in.get());
	}
	
	public double calc(double[] in) {
		double[] currentResult = in;
		for (NeuronLayer nl : neurons) {
			currentResult = nl.calc(currentResult);
		}
		return fn.sum(currentResult);
	}
	
	public void train() {
		for (NeuronLayer nl : neurons)
			nl.train();
	}
	
	public void fullTrain(int[][] data, double[][] expected) {
		for (int i = 0; i < data.length; i++) {
			neurons[i].fullTrain(data[i], expected[i]);
		}
	}
	
	public void fullTrain(int[][] data, double[] expected) {
		for (int i = 0; i < data.length; i++) {
			neurons[i].fullTrain(data[i], expected[i]);
		}
	}
	
	public void fullTrain(int[][] data, double expected) {
		for (int i = 0; i < data.length; i++) {
			neurons[i].fullTrain(data[i], expected);
		}
	}
	
	public String toString() {
		String fromLayers = Arrays.toString(neurons);
		return "NeuralNetwork: " + fromLayers;
	}
}
