package org.fenixsoft.clazz;

/**
 * @author ghaien on 2017/7/18.
 */
public class TestClass {

    private int m;
    public int inc() {
        return m + 1;
    }

    public int intc() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }
}
