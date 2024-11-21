# Design a Calculator

### Enum Operation
```java
public enum Operation {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE;
}
```
### interface Expression
```java
public interface Expression {
    public double evaluate();
}
```
### class Number
```java
public class Number implements Expression{
    double value;
    public Number(double value){
        this.value = value;
    }
    public double evaluate(){
        return value;
    }
}
```
### class ArithmeticExpression
```java
public class ArithmeticExpression implements Expression {
    Expression leftExpression;
    Expression rightExpression;
    Operation operation;

    public ArithmeticExpression(Expression leftPart, Expression rightPart, Operation operation){
        this.leftExpression = leftPart;
        this.rightExpression = rightPart;
        this.operation = operation;
    }

    public double evaluate(){
        double value = 0;
        switch (operation){
            case ADD:
                value = leftExpression.evaluate() + rightExpression.evaluate();
                break;
            case SUBTRACT:
                value = leftExpression.evaluate() - rightExpression.evaluate();
                break;
            case MULTIPLY:
                value = leftExpression.evaluate() * rightExpression.evaluate();
                break;
            case DIVIDE:
            	double denominator = rightExpression.evaluate();
                if (denominator == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                value = leftExpression.evaluate() / denominator;
                break;
            
        }
       return value;
    }
}
```

### Main class
```java
public class Main {

    public static void main(String args[]){
        /* 
          2 * (6 / 3)

                         *
                       /   \
                     2      /
                           / \
                          6   3

        */

        Expression six = new Number(6);
        Expression three = new Number(3);
        Expression divideExpression = new ArithmeticExpression(six, three, Operation.DIVIDE);
        
        Expression two = new Number(2);
        Expression parentExpression = new ArithmeticExpression(two, divideExpression, Operation.MULTIPLY);

        System.out.println(parentExpression.evaluate()); // prints 4.0
    }
}
```
