//: net/mindview/atunit/TestObjectCleanup.java
// The @Unit @TestObjectCleanup tag.

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestObjectCleanup {} ///:~
