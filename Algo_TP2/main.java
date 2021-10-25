import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        Reader miniDico = new Reader("files/minidico.txt");
        Reader dico = new Reader("files/dico.txt");
        Reader fautes = new Reader("files/fautes.txt");
        Levenstein L = new Levenstein("jul", "jel");

        //System.out.println(L.compteur);

       /* int[][] matrice = new int[10][10];
        String x = " ";
        for (int i=0; i<matrice.length;i++){
            for (int j=0; j<matrice[i].length;j++)
                System.out.println(matrice[i][j]);
        }*/

        System.out.println(dico.test("<bonjour>"));

    }
}