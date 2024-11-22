package net.mahtabalam.calculator1;

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


