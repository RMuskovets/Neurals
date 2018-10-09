package org.roman.neurals.tests;

import org.roman.neurals.*;

public class Test1 {

	public static void main(String[] args) {
		Neuron ns[] = {
			new Neuron(0.44),
			new Neuron(0.13),
			new Neuron(-0.4)
		};
		Neuron ns1[] = {
			new Neuron(0.17),
			new Neuron(0.55),
			new Neuron(-0.05)
		};
		NeuronLayer nl = new NeuronLayer(ns);
		System.out.println("Neuron layer #1 before training: " + nl);
		NeuronLayer nl1 = new NeuronLayer(ns1);
		System.out.println("Neuron layer #2 before training: " + nl1);
		NeuronLayer[] nls = {nl, nl1};
		NeuralNetwork net = new NeuralNetwork(new SummingFunction(), nls);
		System.out.println("Network before training: " + net.calc(new double[] {1, 0, 1}));
		net.train();
		System.out.println("Neuron layer #1 after training: " + nl);
		System.out.println("Neuron layer #2 after training: " + nl1);
		System.out.println("Network after training: " + net.calc(new double[] {1, 0, 1}));
	}
}
