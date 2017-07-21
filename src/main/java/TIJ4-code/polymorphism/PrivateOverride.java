//: polymorphism/PrivateOverride.java
// Trying to override a private method.

import static Print.*;

public class PrivateOverride {
  private void f() { Print.print("private f()"); }
  public static void main(String[] args) {
    PrivateOverride po = new Derived();
    po.f();
  }
}

class Derived extends PrivateOverride {
  public void f() { Print.print("public f()"); }
} /* Output:
private f()
*///:~
