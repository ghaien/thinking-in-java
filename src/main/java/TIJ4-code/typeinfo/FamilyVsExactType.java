//: typeinfo/FamilyVsExactType.java
// The difference between instanceof and class

import static Print.*;

class Base {}
class Derived extends Base {}	

public class FamilyVsExactType {
  static void test(Object x) {
    Print.print("Testing x of type " + x.getClass());
    Print.print("x instanceof Base " + (x instanceof Base));
    Print.print("x instanceof Derived "+ (x instanceof Derived));
    Print.print("Base.isInstance(x) "+ Base.class.isInstance(x));
    Print.print("Derived.isInstance(x) " +
      Derived.class.isInstance(x));
    Print.print("x.getClass() == Base.class " +
      (x.getClass() == Base.class));
    Print.print("x.getClass() == Derived.class " +
      (x.getClass() == Derived.class));
    Print.print("x.getClass().equals(Base.class)) "+
      (x.getClass().equals(Base.class)));
    Print.print("x.getClass().equals(Derived.class)) " +
      (x.getClass().equals(Derived.class)));
  }
  public static void main(String[] args) {
    test(new Base());
    test(new Derived());
  }	
} /* Output:
Testing x of type class typeinfo.Base
x instanceof Base true
x instanceof Derived false
Base.isInstance(x) true
Derived.isInstance(x) false
x.getClass() == Base.class true
x.getClass() == Derived.class false
x.getClass().equals(Base.class)) true
x.getClass().equals(Derived.class)) false
Testing x of type class typeinfo.Derived
x instanceof Base true
x instanceof Derived true
Base.isInstance(x) true
Derived.isInstance(x) true
x.getClass() == Base.class false
x.getClass() == Derived.class true
x.getClass().equals(Base.class)) false
x.getClass().equals(Derived.class)) true
*///:~
