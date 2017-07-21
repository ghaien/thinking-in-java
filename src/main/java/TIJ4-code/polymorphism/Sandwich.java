//: polymorphism/Sandwich.java
// Order of constructor calls.

import static Print.*;

class Meal {
  Meal() { Print.print("Meal()"); }
}

class Bread {
  Bread() { Print.print("Bread()"); }
}

class Cheese {
  Cheese() { Print.print("Cheese()"); }
}

class Lettuce {
  Lettuce() { Print.print("Lettuce()"); }
}

class Lunch extends Meal {
  Lunch() { Print.print("Lunch()"); }
}

class PortableLunch extends Lunch {
  PortableLunch() { Print.print("PortableLunch()");}
}

public class Sandwich extends PortableLunch {
  private Bread b = new Bread();
  private Cheese c = new Cheese();
  private Lettuce l = new Lettuce();
  public Sandwich() { Print.print("Sandwich()"); }
  public static void main(String[] args) {
    new Sandwich();
  }
} /* Output:
Meal()
Lunch()
PortableLunch()
Bread()
Cheese()
Lettuce()
Sandwich()
*///:~
