import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Reader {
    HashSet<String> dico = new HashSet<String>();

    public Reader(String fichier) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fichier));
        String line;
        String gauche = "<";
        String droite = ">";
        while ((line = br.readLine()) != null) {
            line = gauche + line + droite;
            dico.add(line);
        }
    }
    /*public String toStringDico(){
        String x = "";
        for (int i=0; i<dico.size();i++){
            x = x +  + "\n";
        }
        return x;
    }*/

    public boolean test(String s){
        return dico.contains(s);
    }

    public int min(int a, int b, int c){
        return Math.min(a,Math.min(b,c));
    }

    public int Lenvenstein(String s1,String s2){
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        int[][] matrice = new int[s1Array.length][s2.length()];
        for (int i=0; i<s1Array.length;i++){
            for (int j=0; j<s2Array.length;j++){
                if (s2Array[j] == s1Array[i]) {matrice[i][j] = matrice[i][j] + 1;}
                else if (s2Array[j] != s1Array[i]){
                    matrice[i][j] = min(matrice[i][j-1],matrice[i-1][j-1],matrice[i-1][j]);}

            }
        }
        return
    }
}
