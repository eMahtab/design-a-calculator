package net.mahtabalam.calculator2;

public class Number implements Expression{
    double value;

    public Number(double value){
        this.value = value;
    }

    public double evaluate(){
        return value;
    }
}
