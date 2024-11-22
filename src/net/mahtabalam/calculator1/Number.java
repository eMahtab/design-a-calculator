package net.mahtabalam.calculator1;

public class Number implements Expression{
    double value;

    public Number(double value){
        this.value = value;
    }

    public double evaluate(){
        return value;
    }
}
