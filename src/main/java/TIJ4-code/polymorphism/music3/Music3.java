//: polymorphism/music3/Music3.java
// An extensible program.

import Note;
import static Print.*;

class Instrument {
  void play(Note n) { Print.print("Instrument.play() " + n); }
  String what() { return "Instrument"; }
  void adjust() { Print.print("Adjusting Instrument"); }
}

class Wind extends Instrument {
  void play(Note n) { Print.print("Wind.play() " + n); }
  String what() { return "Wind"; }
  void adjust() { Print.print("Adjusting Wind"); }
}	

class Percussion extends Instrument {
  void play(Note n) { Print.print("Percussion.play() " + n); }
  String what() { return "Percussion"; }
  void adjust() { Print.print("Adjusting Percussion"); }
}

class Stringed extends Instrument {
  void play(Note n) { Print.print("Stringed.play() " + n); }
  String what() { return "Stringed"; }
  void adjust() { Print.print("Adjusting Stringed"); }
}

class Brass extends Wind {
  void play(Note n) { Print.print("Brass.play() " + n); }
  void adjust() { Print.print("Adjusting Brass"); }
}

class Woodwind extends Wind {
  void play(Note n) { Print.print("Woodwind.play() " + n); }
  String what() { return "Woodwind"; }
}	

public class Music3 {
  // Doesn't care about type, so new types
  // added to the system still work right:
  public static void tune(Instrument i) {
    // ...
    i.play(Note.MIDDLE_C);
  }
  public static void tuneAll(Instrument[] e) {
    for(Instrument i : e)
      tune(i);
  }	
  public static void main(String[] args) {
    // Upcasting during addition to the array:
    Instrument[] orchestra = {
      new Wind(),
      new Percussion(),
      new Stringed(),
      new Brass(),
      new Woodwind()
    };
    tuneAll(orchestra);
  }
} /* Output:
Wind.play() MIDDLE_C
Percussion.play() MIDDLE_C
Stringed.play() MIDDLE_C
Brass.play() MIDDLE_C
Woodwind.play() MIDDLE_C
*///:~
