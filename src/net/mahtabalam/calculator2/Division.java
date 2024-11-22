package net.mahtabalam.calculator2;

public class Division implements Operation {
    public double apply(double left, double right) {
        if (right == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return left / right;
    }
}
