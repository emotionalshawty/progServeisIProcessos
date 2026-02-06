package nf1.sync.filosofs;


public class Filosof extends Thread {
    Forquilla f1;
    Forquilla f2;
    String name;

    public Filosof(String name, Forquilla f1, Forquilla f2) {
        this.name = name;
        this.f1 = f1;
        this.f2 = f2;
    }


    public void run() {
        try {
            while (true) {
                f1.agafar();
                f2.agafar();
                System.out.println(name + " està menjant amb les forquilles " + f1.getId() + " i " + f2.getId());
                try {
                    Thread.sleep((long) (Math.random() * 500) + 200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                f1.deixar();
                f2.deixar();
                System.out.println(name + " ha deixat les forquilles " + f1.getId() + " i " + f2.getId());
                try{
                    Thread.sleep((long) (Math.random() * 500) + 200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}