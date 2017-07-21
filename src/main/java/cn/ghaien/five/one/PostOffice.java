package cn.ghaien.five.one;

import java.util.Iterator;
import java.util.Random;

/**
 * @author ghaien on 2017/7/19.
 */
public class PostOffice {

    enum MailHandler {
        GENERAL_DELIVERY {
            boolean handle(Mail m) {
                switch(m.generalDelivery) {
                    case YES:
                        System.out.println("Using general delivery for " + m);
                        return true;
                    default: return false;
                }
            }
        },
        MACHINE_SCAN {
            boolean handle(Mail m) {
                switch(m.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + m + " automatically");
                                return true;
                        }
                }
            }
        },
        VISUAL_INSPECTION {
            boolean handle(Mail m) {
                switch(m.readability) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Delivering " + m + " normally");
                                return true;
                        }
                }
            }
        },
        RETURN_TO_SENDER {
            boolean handle(Mail m) {
                switch(m.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                System.out.println("Returning " + m + " to sender");
                                return true;
                        }
                }
            }
        };
        abstract boolean handle(Mail m);
    }

    static void handle(Mail m) {
        for (MailHandler handler : MailHandler.values()) {
            if (handler.handle(m)) {
                return;
            }
        }
        System.out.println(m + "is a dead letter");
    }

    public static void main(String[] args) {
        for (Iterator<Mail> it = Mail.generator(10); it.hasNext(); ) {
            Mail mail = it.next();
            System.out.println(mail.details());
            handle(mail);
            System.out.println("*****");
        }
    }
}

class Mail {
    enum GeneralDelivery {YES, NO1, NO2, NO3, NO4, NO5}
    enum Scannability {UNSCANNABLE, YES1, YES2, YES3, YES4}
    enum Readability {ILLEGIBLE, YES1, YES2, YES3, YES4}
    enum Address {INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6}
    enum ReturnAddress {MISSING, OK1, OK2, OK3, OK4, OK5}

    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;

    static long counter = 0;
    long id = counter++;

    public String toString() {
        return "Mail: " + id;
    }

    public String details() {
        return toString() +
                ", General Delivery: " + generalDelivery +
                ", Address Scannability: " + scannability +
                ", Address Readability: " + readability +
                ", Address Address: " + address +
                ", Return address: " + returnAddress;
    }

    public static Mail randomMail() {
        Mail m = new Mail();
        m.generalDelivery = random(GeneralDelivery.class);
        m.scannability = random(Scannability.class);
        m.readability = random(Readability.class);
        m.address = random(Address.class);
        m.returnAddress = random(ReturnAddress.class);
        return m;
    }
    static Random random = new Random(47);
    public static <T extends Enum<T>> T random(Class<T> c) {

        return c.getEnumConstants()[random.nextInt(c.getEnumConstants().length)];
    }

    public static Iterator<Mail> generator(final int count) {
        return new Iterator<Mail>() {
            int n = count;
            public boolean hasNext() {
                return n-- > 0;
            }

            public Mail next() {
                return randomMail();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
