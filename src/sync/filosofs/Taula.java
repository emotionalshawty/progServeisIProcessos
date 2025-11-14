package sync.filosofs;

import java.util.concurrent.Semaphore;

public class Taula {
    public static void main(String[] args) {
        Semaphore semafor = new Semaphore(2); // Només 2 filòsofs poden menjar alhora

        Forquilla f1 = new Forquilla(1);
        Forquilla f2 = new Forquilla(2);
        Forquilla f3 = new Forquilla(3);
        Forquilla f4 = new Forquilla(4);

        Filosof fil1 = new Filosof("Socrates", f1, f2);
        Filosof fil2 = new Filosof("Plato", f2, f3);
        Filosof fil3 = new Filosof("Aristotle", f3, f4);
        Filosof fil4 = new Filosof("Descartes", f1, f4);

        fil1.start();
        fil2.start();
        fil3.start();
        fil4.start();

    }
}
