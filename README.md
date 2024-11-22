# Design a Calculator

The code sample have two packages `calculator1` and `calculator2`.

The code sample in package `calculator1` uses enum for declaring an Operation type (e.g. ADD, SUBTRACT, MULTIPLY, DIVIDE) but if you want to extend the number of operations
supported by calculator you will have to modify the enum and also the ArithmeticExpression class where we implement those operation, within the switch statement.
This approach breaks the Open/Closed principle which states classes should be open for extension but closed for modifications.

!["Java Code for a Calculator Design"](calculator.png?raw=true)

### Strategy Pattern to the rescue:
