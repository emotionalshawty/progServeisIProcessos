package nf1.sync.galetes;

public class Fills extends Thread {
    final private MainCookies ck;

    public Fills(String nom, MainCookies ck) {
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
