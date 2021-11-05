import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Reader {
    ArrayList<String> dico;

    public Reader(String fichier) throws IOException {
        HashSet<String> dico = new HashSet<String>();
        BufferedReader br = new BufferedReader(new FileReader(fichier));
        String line;
        String gauche = "<";
        String droite = ">";
        while ((line = br.readLine()) != null) {
            line = gauche + line + droite;
            dico.add(line);
        }
        this.dico = new ArrayList<>(dico);
    }

    public boolean test(String s){
        return dico.contains(s);
    }
}