package cn.ghaien.five.one;

import java.util.Random;

/**
 * @author ghaien on 2017/7/19.
 */
public enum Input {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        public int amout() {
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP {
        public int amout() {
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    };

    int value;
    Input(int value) {
        this.value = value;
    }
    Input() {

    }
    public int amount() {
        return value;
    }

    static Random random = new Random(47);

    public static Input randomSelection() {
        return values()[random.nextInt(values().length - 1)];
    }
}
