package net.mahtabalam;

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

        System.out.println(parentExpression.evaluate());
    }
}

