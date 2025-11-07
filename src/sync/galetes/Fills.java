package sync.galetes;

public class Fills extends Thread {
    final private Cookies ck;

    public Fills(String nom, Cookies ck) {
        super(nom);
        this.ck = ck;
    }

    @Override
    public void run() {

        for(;;) {
            ck.agafar(getName());

            try {
                System.out.println(getName() + " ha agafat una galeta");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

    }
}
