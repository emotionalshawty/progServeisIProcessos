package sync.galetes;

public class Pot {
    private final int MAX = 20;
    private int count;

    public Pot() {
        this.count = MAX;
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void agafant() {
        if (count > 0) count--;
    }

    public int refill() {
        int added = MAX - count;
        count = MAX;
        return added;
    }


}
