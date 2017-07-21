package cn.ghaien.five.one;

import java.util.Random;

/**
 * @author ghaien on 2017/7/19.
 */
// Outcome WIN LOSE DRAW Item compete eval Paper Scissors Rock newItem match
public class RoShamBo {
    static Random random = new Random(47);

    public static Item newItem() {
        switch (random.nextInt(3)) {
            default:
            case 1:
                return new Paper();
            case 0:
                return new Scissors();
            case 2:
                return new Rock();
        }
    }

    public static void match(Item item1, Item item2) {
        System.out.println(item1 + " vs " + item2 + " = " + item1.compete(item2));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            match(newItem(), newItem());
        }
    }
}

enum Outcome {
    WIN, LOSE, DRAW
}

interface Item {
    Outcome compete(Item item);
    Outcome eval(Paper paper);
    Outcome eval(Scissors scissors);
    Outcome eval(Rock rock);
}

class Paper implements Item {
    public Outcome compete(Item item) {
        return item.eval(this);
    }

    public Outcome eval(Paper paper) {
        return Outcome.DRAW;
    }

    public Outcome eval(Scissors scissors) {
        return Outcome.WIN;
    }

    public Outcome eval(Rock rock) {
        return Outcome.LOSE;
    }

    public String toString() {
        return "Paper";
    }
}

class Scissors implements Item {
    public Outcome compete(Item item) {
        return item.eval(this);
    }

    public Outcome eval(Paper paper) {
        return Outcome.LOSE;
    }

    public Outcome eval(Scissors scissors) {
        return Outcome.DRAW;
    }

    public Outcome eval(Rock rock) {
        return Outcome.WIN;
    }

    public String toString() {
        return "Scissors";
    }
}

class Rock implements Item {
    public Outcome compete(Item item) {
        return item.eval(this);
    }

    public Outcome eval(Paper paper) {
        return Outcome.WIN;
    }

    public Outcome eval(Scissors scissors) {
        return Outcome.LOSE;
    }

    public Outcome eval(Rock rock) {
        return Outcome.DRAW;
    }

    public String toString() {
        return "Rock";
    }
}
