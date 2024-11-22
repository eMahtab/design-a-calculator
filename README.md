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
