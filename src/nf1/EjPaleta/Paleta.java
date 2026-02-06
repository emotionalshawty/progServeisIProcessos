package nf1.EjPaleta;

public class Paleta implements Runnable{

    private void posarMaons(int numMaons) throws InterruptedException {
        System.out.println("estic posant maons...");
        Thread.sleep((long)(Math.random()*2000 )+ 1000);
    }
    @Override
    public void run() {

    }
}
