package org.roman.neurals.v2;

import org.roman.neurals.*;

public class NeuronConnection {

    private final Neuron a, b;
    private double weight;

    public NeuronConnection(Neuron a, Neuron b) {
        this.a = a;
        this.b = b;
    }

    public Neuron getA() {
        return a;
    }

    public Neuron getB() {
        return b;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
