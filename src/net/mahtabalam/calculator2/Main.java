package net.mahtabalam.calculator2;

public class Main {
    public static void main(String[] args) {
        Expression number1 = new Number(3);
        Expression number2 = new Number(5);

        // Adding 3 + 5
        Expression addition = new ArithmeticExpression(number1, number2, new Addition());

        Expression number3 = new Number(2);

        // Multiplying (3 + 5) * 2
        Expression multiplication = new ArithmeticExpression(addition, number3, new Multiplication());

        System.out.println("Result: " + multiplication.evaluate()); // Outputs 16.0

        // Adding Modulus Operation: (16 % 3)
        Expression modulus = new ArithmeticExpression(multiplication, new Number(3), new Modulus());
        System.out.println("Result: " + modulus.evaluate()); // Outputs 1.0

        // Adding Power Operation: (3 ^ 5)
        Expression power = new ArithmeticExpression(number1, number2, new Power());
        System.out.println("Result: " + power.evaluate()); // Outputs 243.0
    }
}

