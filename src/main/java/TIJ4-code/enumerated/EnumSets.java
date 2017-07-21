//: enumerated/EnumSets.java
// Operations on EnumSets

import java.util.*;
import static enumerated.AlarmPoints.*;
import static Print.*;

public class EnumSets {
  public static void main(String[] args) {
    EnumSet<AlarmPoints> points =
      EnumSet.noneOf(AlarmPoints.class); // Empty set
    points.add(BATHROOM);
    Print.print(points);
    points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
    Print.print(points);
    points = EnumSet.allOf(AlarmPoints.class);
    points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
    Print.print(points);
    points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
    Print.print(points);
    points = EnumSet.complementOf(points);
    Print.print(points);
  }
} /* Output:
[BATHROOM]
[STAIR1, STAIR2, BATHROOM, KITCHEN]
[LOBBY, OFFICE1, OFFICE2, OFFICE3, OFFICE4, BATHROOM, UTILITY]
[LOBBY, BATHROOM, UTILITY]
[STAIR1, STAIR2, OFFICE1, OFFICE2, OFFICE3, OFFICE4, KITCHEN]
*///:~
