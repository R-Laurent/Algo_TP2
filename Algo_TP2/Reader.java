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
}
