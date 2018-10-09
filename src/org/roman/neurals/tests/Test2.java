package org.roman.neurals.tests;

import org.roman.neurals.*;

public class Test2 {
	public static void main(String args[]) {
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
		NeuronLayer nl1 = new NeuronLayer(ns1);
		NeuronLayer[] nls = {nl, nl1};
		NeuralNetwork net = new NeuralNetwork(new SummingFunction(), nls);
		InputLayer in = new RandomDataInputLayer(3);
		for (double d : in.get()) System.out.print(d + " ");
		System.out.println();
		System.out.println(net.calc(in));
		net.train();
		System.out.println(net.calc(in));
	}
}
