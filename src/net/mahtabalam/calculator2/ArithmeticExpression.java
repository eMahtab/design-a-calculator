package net.mahtabalam.calculator2;

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