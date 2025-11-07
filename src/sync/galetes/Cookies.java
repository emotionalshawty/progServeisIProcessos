package sync.galetes;

public class Cookies {
    private final Pot pot = new Pot();

    public void run(){
        while(true){
            pot.agafant();
        }
    }
    public synchronized void agafar(String who) {
        while (pot.isEmpty()) {
            try {
                System.out.println(who + " esta esperant per mes galetes");
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        pot.agafant();
        System.out.println(who + " ha agafat una galeta, hi queden " + pot.getCount());
        if (pot.getCount() <= 5) {
            notifyAll();
        }
    }

    public synchronized void replenar(String who) {
        while (pot.getCount() > 5) {
            try {
                System.out.println(who + " sees enough cookies, will wait.");
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        int added = pot.refill();
        System.out.println(who + " ha replenat " + added);
        notifyAll();
    }
}
