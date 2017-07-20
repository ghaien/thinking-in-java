package cn.ghaien.five.one;

import java.util.Random;

/**
 * @author ghaien on 2017/7/13.
 */
public class Demo2 {

    public String s1 = "Hello";

    public String s2;

    public Demo2() {
        s2 = "hi";
    }
}

class Demo2Test {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Demo2 demo2 = new Demo2();
        System.out.println(demo2.s1);
        System.out.println(demo2.s2);

        Class demo2Class = Demo2.class;
        Demo2 demo3 = (Demo2)demo2Class.newInstance();
        System.out.println(demo3.s2);
        System.out.println(demo3.s1);
    }
}

class Test1 {

    static void f(float f, Character... args) {
        System.out.println("first");
    }

    static void f(char c, Character... args) {
        System.out.println("second");
    }

    public static void main(String[] args) {
        f(0.0f, 'c');
        f('c', 'c');
    }
}

enum Spiciness {

    NOT, HOT, MILD;

    private String name;
}

class Burrito {

    public Spiciness degree;

    public Burrito(Spiciness spiciness) {
        degree = spiciness;
    }

    public String toString() {
        return degree.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Burrito(Spiciness.NOT));
    }
}

class Enums {

    private static Random random = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[random.nextInt(values.length)];
    }
}



enum Course {
    MAINCOURCE(Food.MainCource.class),
    DESSERT(Food.Dessert.class);

    private Food[] values;

    private Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection() {
        return Enums.random(values);
    }

    interface Food{

        enum MainCource implements Food {
            BURRITO, PAD_THAI
        }

        enum Dessert implements Food {
            TEA, COFFEE
        }
    }
}

class Test2 {

    public static void main(String[] args) {
        Course.Food food = Course.Food.MainCource.BURRITO;

        food = Course.Food.Dessert.COFFEE;

        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                System.out.println(course.randomSelection());
            }
        }

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

    }
}