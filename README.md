# Design a Calculator

The code sample have two packages `calculator1` and `calculator2`.

The code sample in package `calculator1` uses enum for declaring an Operation type (e.g. ADD, SUBTRACT, MULTIPLY, DIVIDE) but if you want to extend the number of operations
supported by calculator you will have to modify the enum and also the ArithmeticExpression class where we implement those operation, within the switch statement.
**This approach breaks the Open/Closed principle which states classes should be open for extension but closed for modifications.**

!["Java Code for a Calculator Design"](calculator.png?raw=true)

## Strategy Pattern to the rescue:
Suppose we want to now support new operations (e.g. modulus and power). By using the Strategy pattern we can achieve this without violating the Open/Closed principle.

### Operation interface
```java
public interface Operation {
	double apply(double left, double right);
}
```

### Different implementations of Operation interface
```java
/* Addition.java */
public class Addition implements Operation {
    public double apply(double left, double right) {
        return left + right;
    }
}

/* Subtraction.java */
public class Subtraction implements Operation {
    public double apply(double left, double right) {
        return left - right;
    }
}

/* Multiplication.java */
public class Multiplication implements Operation {
    public double apply(double left, double right) {
        return left * right;
    }
}

/* Division.java */
public class Division implements Operation {
    public double apply(double left, double right) {
        if (right == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return left / right;
    }
}

/* Modulus.java */
public class Modulus implements Operation {
    public double apply(double left, double right) {
        return left % right;
    }
}

/* Power.java */
public class Power implements Operation {
    public double apply(double left, double right) {
        return Math.pow(left, right);
    }
}
```

### ArithmeticExpression
```java
public class ArithmeticExpression implements Expression {
    Expression leftExpression;
    Expression rightExpression;
    Operation operation;

    public ArithmeticExpression(Expression leftPart, Expression rightPart, Operation operation) {
        this.leftExpression = leftPart;
        this.rightExpression = rightPart;
        this.operation = operation;
    }

    public double evaluate() {
        return operation.apply(leftExpression.evaluate(), rightExpression.evaluate());
    }
}
```

### Main.java
```java
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
```
