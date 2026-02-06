package nf1.multiplicallista;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MultiplicacioLlistaSeq {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        List<MultiplicacioSeq> llistaTasques= new ArrayList<MultiplicacioSeq>();
        for (int i = 0; i < 10; i++) {
            MultiplicacioSeq calcula = new MultiplicacioSeq((int)(Math.random()*10), (int)(Math.random()*10));
            llistaTasques.add(calcula);
        }
        List<Integer> llistaResultats = new ArrayList<>();
        //llistaResultats = executor.invokeAll(llistaTasques);

        Long ti = System.currentTimeMillis();
        for (int i = 0; i < llistaTasques.size(); i++) {
            llistaResultats.add(llistaTasques.get(i).operar());
        }
        Long tf = System.currentTimeMillis();

        //executor.shutdown();

        for (int i = 0; i < llistaResultats.size(); i++) {
            Integer resultat = llistaResultats.get(i);
            System.out.println("Resultat tasca "+i+ " és:" + resultat);
        }
        System.out.println("ha trigat " + (tf-ti) + " milisegons");

    }
}
