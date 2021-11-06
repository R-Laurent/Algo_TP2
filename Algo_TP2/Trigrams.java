import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Trigrams {
    HashMap<String,HashSet<String>> trigrams = new HashMap<>();
    public Trigrams(Reader r){
        ArrayList<String> dico = new ArrayList<>(r.dico);
        for (int i=0;i<dico.size();i++){
            String word = dico.get(i);
            ArrayList<String> tri = new ArrayList<String>();
            for (int j=0;j<word.length()-2;j++){
                String tr = word.substring(j,j+3);
                tri.add(tr);
                if (trigrams.keySet().contains(tr) == false){
                    HashSet<String> liste = new HashSet<String>();
                    trigrams.put(tr,liste);}
                trigrams.get(tr).add(word);
            }
        }
    }

}