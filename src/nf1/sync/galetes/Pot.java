package nf1.sync.galetes;

public class Pot {
    private static final int MAX = 20;
    private int count;

    public Pot() {
        this.count = MAX;
    }

    public synchronized int getCount() {
        return count;
    }

    public synchronized boolean isEmpty() {
        return count == 0;
    }

    public synchronized void agafant() {
        if (count > 0) count--;
    }

    public synchronized int refill() {
        int added = MAX - count;
        count = MAX;
        return added;
    }


}
