package sync.galetes;


public class Pares extends Thread {
    private final MainCookies ck;

    public Pares(String name, MainCookies ck) {
        super(name);
        this.ck = ck;
    }


    @Override
    public void run() {
        for(;;) {
            ck.replenar(getName());
            try {
                Thread.sleep((long) (Math.random() * 500) + 200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
