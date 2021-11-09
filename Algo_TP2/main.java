import java.io.IOException;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        double debut = System.nanoTime();
        Reader dico = new Reader("files/dico.txt");
        Reader fautes = new Reader("files/fautes.txt");
        Trigrams t1 = new Trigrams(dico);
        Correction c1 = new Correction(t1, fautes.dico);
        //correctionTest ct1 = new correctionTest("<abbatage>",t1);
        double fin = System.nanoTime();
        double temps = (fin - debut)/1000000000;
        //System.out.println(ct1.correction);
        //System.out.println("nombre de mots corrigés : "+c1.corrections.size());
        System.out.println("le temps mis est : " + temps+ " secondes");
        System.out.println(fautes.dico.size());
    }
}