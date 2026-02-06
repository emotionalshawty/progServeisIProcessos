package nf1.sequencial;

import java.util.concurrent.RecursiveTask;

public class dividir extends RecursiveTask<Long> {
    private long dividiendo;
    private long divisor;
    static final long LLINDAR = 15;


    public dividir(long dividiendo, long divisor) {
        this.dividiendo = dividiendo;
        this.divisor = divisor;
    }

    public long divSeq() {
        long cont = 0;
        while (dividiendo >= divisor) {
            dividiendo -= divisor;
            cont++;
        }
        return cont;
    }

    public long divR() {
        dividir task = new dividir(dividiendo - divisor, divisor);
        task.fork();
        return 1 + task.join();
    }
    @Override
    protected Long compute() {
        if (dividiendo<LLINDAR){
            return divSeq();
        }else{
            return divR();
        }
    }

    class dividirMain{
        public static void main(String[] args) {
            dividir division = new dividir(100, 3);
            long result = division.compute();
            System.out.println("Resultat final: " + result);
        }
    }


}
