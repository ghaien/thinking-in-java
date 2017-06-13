package com.ghaien.operators;//: operators/Exponents.java
// "e" means "10 to the power."
import static net.mindview.util.Print.*;

public class Exponents {
  public static void main(String[] args) {
    // Uppercase and lowercase 'e' are the same:
    float expFloat = 1.39e-43f;
    expFloat = 1.39E-43f;
    System.out.println(expFloat);
    double expDouble = 47e47d; // 'd' is optional
    double expDouble2 = 47e47; // Automatically double
    System.out.println(expDouble);
    print(1e-43f);
    print("float.max: " + Float.MAX_VALUE);
    print("float.min: " + Float.MIN_VALUE);
    print("double.max: " + Double.MAX_VALUE);
    print("double.min: " + Double.MIN_VALUE);
  }
} /* Output:
1.39E-43
4.7E48
*///:~
