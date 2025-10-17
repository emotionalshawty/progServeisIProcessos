package sequencial;


import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FibonacciSeq  extends RecursiveTask <Long> {
    public static int LLINDAR = 40;
    private int n;

    public FibonacciSeq(int n) {
        this.n = n;
    }

    private long fibonacciSeq() {
        if (n <= 1) return n;
        long n1 = 0, n2 = 1, n3 = 1;
        for (int i = 2; i <= n; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
        }
        return n3;
    }

    private long fibonacciR() {
        FibonacciSeq f1 = new FibonacciSeq(n - 1);
        f1.fork();
        FibonacciSeq f2 = new FibonacciSeq(n - 2);
        return f2.compute() + f1.join();
    }

    @Override
    protected Long compute() {
        if (n <= LLINDAR) return fibonacciSeq();
        else return fibonacciR();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ForkJoinPool pool = new ForkJoinPool();
        FibonacciSeq task = new FibonacciSeq(n);
        long startTime = System.nanoTime();
        long result = pool.invoke(task);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Fibonacci(" + n + ") = " + result);
        System.out.println("Time taken: " + duration + " nanoseconds");
        sc.close();
    }


}
