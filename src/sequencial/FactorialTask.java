package sequencial;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import static sequencial.MaximTask.LLINDAR;

public class FactorialTask extends RecursiveTask<Long> {
    private int n;
    public FactorialTask(int n) {
        this.n = n;
    }

    private long factorialSeq() {
        long temp = 1;
        for (int i = 2; i <= n; i++) {
            temp = temp * i;
        }
        return temp;
    }

    private long factorialR(){
        FactorialTask task = new FactorialTask(n - 1);
        task.fork();
        return n * task.join();
    }


    @Override
    protected Long compute() {
        if (n < LLINDAR) return factorialSeq();
        else return factorialR();
    }

    class MainFactorial{
        public static void main(String[] args) {
        FactorialTask factorial = new FactorialTask(10);
            ForkJoinPool pool = new ForkJoinPool();
            long result = pool.invoke(factorial);
            System.out.println("Resultat final: " + result);
        }
    }
}
