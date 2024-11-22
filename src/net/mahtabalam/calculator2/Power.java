package net.mahtabalam.calculator2;

public class Power implements Operation {
    public double apply(double left, double right) {
        return Math.pow(left, right);
    }
}
