/**
 * @author ghaien on 2017/7/17.
 */
public class Bar {

    int a = 1;
    static int b = 2;
    public int sum(int c) {
        return a + b + c;
    }

    public static void main(String[] args) throws InterruptedException {
        new Bar().sum(3);
        Thread.sleep(100000);
    }
}
