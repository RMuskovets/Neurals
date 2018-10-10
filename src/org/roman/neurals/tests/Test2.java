package org.roman.neurals.tests;

import org.roman.neurals.*;

import java.util.*;
import java.util.stream.*;

public class Test2 {

	private static NeuronLayer generateNeurons(int len) {
		Random rand = new Random();
		double[] range = Range.range(0, 1, 0.01);
		double[] data = new double[len];
		for (int i = 0; i < len; ++i) {
			data[i] = range[rand.nextInt(range.length)];
		}
		Stream<Neuron> neurons = Arrays.<Double>stream(data)
				.mapToObj(Neuron::new);
		return new NeuronLayer((Neuron[]) neurons.toArray());
	}

	public static void main(String args[]) {
		Neuron ns[] = {
				new Neuron(0.44),
				new Neuron(0.13),
				new Neuron(-0.4),
				new Neuron(0.17),
				new Neuron(0.55),
		};
		Neuron ns1[] = {
				new Neuron(0.17),
				new Neuron(0.55),
				new Neuron(-0.05),
				new Neuron(0.17),
				new Neuron(0.55),
		};
		NeuronLayer nl = new NeuronLayer(ns);
		NeuronLayer nl1 = new NeuronLayer(ns1);
		NeuronLayer[] nls = {nl, nl1};
		NeuralNetwork net = new NeuralNetwork(new SummingFunction(), nls);
		InputLayer in = new RandomDataInputLayer(5);
		for (double d : in.get()) System.out.print(d + " ");
		System.out.println();
		System.out.println(net.calc(in));
		net.train();
		System.out.println(net.calc(in));
		if (!isOnlyZeros(in.get())) {
			double exp = 0.45;
			System.out.println("Full training to " + exp);
			long startms = System.currentTimeMillis();
			//net.fullTrain(data, 0.45);
			net.fullTrain(in.get(), exp);
			long duration = System.currentTimeMillis() - startms;
			System.out.println("Finished. Elapsed " + duration / 1000.0 + " seconds");
			double res = net.calc(in);
			System.out.println("Result: " + res);
			System.out.println("Result (bool): " + (res >= 0.5));
		}
	}

	private static boolean isOnlyZeros(double[]x) {
		boolean b[] = new boolean[x.length];
		for (int i=0;i<b.length;i++) b[i] = (x[i] == 0);
		boolean and = true;
		for (boolean c:b) and &= c;
		return and;
	}

	private static Double[] toDO(double[]x) {
		Double[]y=new Double[x.length];
		for(int i=0;i<y.length;i++)y[i]=x[i];
		return y;
	}
}
