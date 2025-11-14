package sync.filosofs;

public class Forquilla {
    private boolean enUs;
    private final int id;

    public Forquilla(int id) {
        this.enUs = false;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public synchronized void agafar() throws InterruptedException {
        while (enUs) {
            wait();
        }
        enUs = true;
    }

    public synchronized void deixar() {
        enUs = false;
        notifyAll();
    }
}
