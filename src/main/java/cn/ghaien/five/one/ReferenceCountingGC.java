package cn.ghaien.five.one;

import java.util.Map;
import java.util.Set;

/**
 * @author ghaien on 2017/7/14.
 */
public class ReferenceCountingGC {

    public Object instance = null;
    private static final int _MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        System.gc();
    }

    public static void main(String[] args) {
//        testGC();
        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();
        Set<Map.Entry<Thread, StackTraceElement[]>> set = map.entrySet();
        for (Map.Entry<Thread, StackTraceElement[]> entry : set) {
            Thread thread = entry.getKey();
            StackTraceElement[] stack = entry.getValue();

            if (thread.equals(Thread.currentThread())) {
                continue;
            }
            System.out.println("\n线程: " + thread.getName() + "\n");
            for (StackTraceElement element : stack) {
                System.out.println("element: " + element);
            }
        }
    }
}

