//: interfaces/interfaceprocessor/Apply.java

import static Print.*;

public class Apply {
  public static void process(Processor p, Object s) {
    Print.print("Using Processor " + p.name());
    Print.print(p.process(s));
  }
} ///:~
