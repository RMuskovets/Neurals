package org.roman.neurals.saving;

import org.roman.neurals.NeuralNetwork;

import java.io.*;

public class Saver {

    public byte[] save(NeuralNetwork x) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(x);
            return baos.toByteArray();
        } catch (IOException e) {
        }
        return new byte[0];
    }

    public NeuralNetwork load(byte[] data) {
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        try {
            ObjectInputStream ois = new ObjectInputStream(bais);
            return (NeuralNetwork) ois.readObject();
        } catch (Exception e) {
        }
        return null;
    }
}
