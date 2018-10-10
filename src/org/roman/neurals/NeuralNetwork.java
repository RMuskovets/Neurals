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

	public void fullTrain(int data[], double expected) {
		double curres[] = toda(data);
		while (calc(curres)<expected||calc(curres)<-expected) train();
	}

	public void fullTrain(double data[], double expected) {
		while (calc(data)<expected||calc(data)<-expected) train();
	}

	public String toString() {
		String fromLayers = Arrays.toString(neurons);
		return "NeuralNetwork: " + fromLayers;
	}

	private static double[] toda(int x[]) {
		double y[] = new double[x.length];
		for(int i=0;i<x.length;i++)y[i]=x[i];
		return y;
	}
}
