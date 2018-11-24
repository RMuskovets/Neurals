package org.roman.neurals.v2;

import org.roman.neurals.Neuron;

import java.util.ArrayList;
import java.util.List;

public class NeuronLayer extends org.roman.neurals.NeuronLayer {

    protected NeuronConnection[] connections;

    public NeuronLayer(int nc, double allWeight) {
        super (nc, allWeight);
        List<NeuronConnection> ncs = new ArrayList<>();
        for (int i = 0; i < nc; i++) {
            if (i == nc - 1) break;

        }
    }

    public NeuronLayer(Neuron... ns) {

    }

    @Override @Deprecated
    /**
     * Calculate the value of neuron with ID.
     * @throws none
     * @returns In previous version: (neuron with ID ...).weight * input, now: -1
     */
    public double calc(int neuronID, double input) {
        //return super.calc(neuronID, input);
        return -1;
    }

    @Override @Deprecated
    public double weight(int neuronID) {
        //return super.weight(neuronID);
        return -1;
    }

    @Override
    public void train() {

    }
}
