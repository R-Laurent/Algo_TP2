import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class main {
    public static void main(String[] args) throws IOException {
        Reader miniDico = new Reader("files/minidico.txt");
        Reader dico = new Reader("files/dico.txt");
        Reader fautes = new Reader("files/fautes.txt");
        Levenstein L = new Levenstein("jul", "jel");

        System.out.println(L.compteur);

        System.out.println(dico.test("<chauve>"));
        String w1 = "<bonjour>";
        String w2 = "<bonheur>";
        /*for (int i=0; i<w2.length()-2;i++){
            System.out.println(w2.substring(i,i+3));
        }*/
        ArrayList<String> words = new ArrayList<String>();
        words.add(w1);
        words.add(w2);
        HashMap<String,ArrayList<String>> trigrams = new HashMap<>();
        for (int i=0;i<words.size();i++){
            String word = words.get(i);
            for (int j=0;j<word.length()-2;j++){
                ArrayList<String> tri = new ArrayList<String>();
                ArrayList<String> liste = new ArrayList<String>();
                String tr = word.substring(j,j+3);
                trigrams.put(tr,liste);
                tri.add(tr);
                for (int k=0; k< tri.size();k++){ trigrams.get(tri.get(k)).add(word); }
            }
        }
        System.out.println(trigrams.keySet());
        for (int i = 0; i<trigrams.get("bon").size();i++){
            System.out.println("la taille : " + trigrams.get("bon").size());
            System.out.println(trigrams.get("bon").get(i));
        }
    }
}