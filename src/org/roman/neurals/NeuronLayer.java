package org.roman.neurals;

import java.io.Serializable;
import java.util.Arrays;

@Deprecated
public class NeuronLayer implements Serializable {
	protected int neuronCount;
	protected Neuron[] neurons;
	
	public NeuronLayer(int nc, double allWeight) {
		neuronCount = nc;
		for (int i = 0; i < nc; i++)
			neurons[i] = new Neuron(allWeight);
	}
	
	public NeuronLayer(Neuron... ns)  {
		neuronCount = ns.length;
		neurons = ns;
	}
	
	public double calc(int neuronID, double input) {
		return neurons[neuronID].calc(input);
	}
	
	public double weight(int neuronID) {
		return neurons[neuronID].weight();
	}
	
	public int getNeuronCount() {
		return neuronCount;
	}
	
	public Neuron get(int neuronID) {
		return neurons[neuronID];
	}
	
	public double[] calc(double[] input) {
		assert input.length == neuronCount;
		double[] out = new double[neuronCount];
		for (int i = 0; i < neuronCount; i++) {
			out[i] = neurons[i].calc(input[i]);
		}
		return out;
	}
	
	public void train() {
		for (Neuron n : neurons) n.train();
	}
	
	public String toString() {
		String fromNeurons = Arrays.toString(neurons);
		return "NeuronLayer: " + fromNeurons;
	}
	
	public void fullTrain(int[] data, double[] expected) {
		for (int i = 0; i < data.length; i ++) {
			neurons[i].fullTrain(data[i], expected[i]);
		}
	}
	
	public void fullTrain(int[] data, double expected) {
		double[] exp = new double[data.length];
		Arrays.fill(exp, expected);
		fullTrain(data, exp);
	}
}
