//: typeinfo/packageaccess/HiddenC.java

import typeinfo.interfacea.*;
import static Print.*;

class C implements A {
  public void f() { Print.print("public C.f()"); }
  public void g() { Print.print("public C.g()"); }
  void u() { Print.print("package C.u()"); }
  protected void v() { Print.print("protected C.v()"); }
  private void w() { Print.print("private C.w()"); }
}

public class HiddenC {
  public static A makeA() { return new C(); }
} ///:~
