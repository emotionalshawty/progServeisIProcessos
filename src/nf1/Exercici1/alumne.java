package nf1.Exercici1;

import java.util.concurrent.Callable;

public class alumne implements Callable<Integer> {
    private String nom;
    public alumne(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public int examinar() {
        return (int)(Math.random() * 10);
    }

    @Override
    public Integer call() throws Exception {
        return examinar();
    }

}
