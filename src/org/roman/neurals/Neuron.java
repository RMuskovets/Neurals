package org.roman.neurals;

public class Neuron {
	private double weight;
	
	public static double LEARNING_RATE = 0.17;
	
	public Neuron(double w) {
		weight = w;
	}
	
	public double calc(double in) {
		return weight * in;
	}
	
	public double weight() {
		return weight;
	}
	
	public void train() {
		weight += LEARNING_RATE;
	}
	
	public String toString() {
		return "Neuron [weight=" + weight + "]";
	}
	
	public void fullTrain(int data, double expected) {
		do {
			train();
		} while (calc(data) < expected);
	}
}
