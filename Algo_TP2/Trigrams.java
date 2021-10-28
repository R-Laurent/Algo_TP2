import java.util.ArrayList;
import java.util.HashMap;

public class Trigrams {
    HashMap<String,ArrayList<String>> trigrams = new HashMap<>();
    public Trigrams(Reader r){
        ArrayList<String> dico = new ArrayList<>(r.dico);
        for (int i=0;i<dico.size();i++){
            String word = dico.get(i);
            ArrayList<String> tri = new ArrayList<String>();
            //ArrayList<String> liste = new ArrayList<String>();
            for (int j=0;j<word.length()-2;j++){
                ArrayList<String> liste = new ArrayList<String>();
                String tr = word.substring(j,j+3);
                tri.add(tr);
                trigrams.put(tr,liste);
                //trigrams.get(tr).add(word);
            }
            //for (int k=0;k<tri.size();k++){trigrams.get(tri.get(k)).add(word);}
        }
        for (int i=0;i<dico.size();i++){
            ArrayList<String> tri = new ArrayList<String>();
            String word = dico.get(i);
            for (int j=0;j<word.length()-2;j++){
                ArrayList<String> liste = new ArrayList<String>();
                String tr = word.substring(j,j+3);
                tri.add(tr);
            }
            for (int k=0;k<tri.size();k++){trigrams.get(tri.get(k)).add(word);}
        }
    }
}