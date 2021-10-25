import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        Reader miniDico = new Reader("files/minidico.txt");
        Reader dico = new Reader("files/dico.txt");
        Reader fautes = new Reader("files/fautes.txt");
        Levenstein L = new Levenstein("jul", "jel");

        System.out.println(L.compteur);

        System.out.println(dico.test("<chauve>"));

    }
}