package sync.galetes;

public class Main {
    public static void main(String[] args) {
        Cookies ck = new Cookies();
        Pares pare = new Pares("Pare", ck);
        Pares mare = new Pares("Mare", ck);
        Fills fill1 = new Fills("Fill 1", ck);
        Fills fill2 = new Fills("Fill 2", ck);

        pare.start();
        mare.start();
        fill1.start();
        fill2.start();
    }
}
