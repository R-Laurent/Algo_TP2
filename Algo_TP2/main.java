import java.io.IOException;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        double debut = System.nanoTime();
        Reader dico = new Reader("files/dico.txt");
        Reader fautes = new Reader("files/fautes.txt");
        Trigrams t1 = new Trigrams(dico);
        Correction c1 = new Correction(t1, fautes.dico);
        double fin = System.nanoTime();
        System.out.println("Le temps mis est : " + (fin - debut)/1000000000+ " secondes.");
    }
}