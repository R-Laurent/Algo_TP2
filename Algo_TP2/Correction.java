import java.util.*;

public class Correction {
    Trigrams t;
    public HashSet<String> trigramCommun(String word, Trigrams t){
        HashMap<String,Integer> occurences = new HashMap<String, Integer>();
        HashSet<String> c = new HashSet<>();
        ArrayList<String> tri = getTrigrams(word);
        c.add(word);
        for (int i=0;i<tri.size();i++){
            for (int j=0;j<t.trigrams.get(tri.get(i)).size();j++){
                String motCommun = t.trigrams.get(tri.get(i)).get(j);
                c.add(motCommun);
                Integer compteur = 0;
                for (int k=0;k<tri.size();k++){
                    if (t.trigrams.get(tri.get(k)).contains(motCommun)){compteur++;}
                }
                occurences.put(motCommun,compteur);
            }
        }
        List<Map.Entry<String,Integer>> list = new LinkedList<Map.Entry<String, Integer>>(occurences.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        return c;
    }

    public List<Map.Entry<String,Integer>> nbrOccurence(HashSet<String> commun, ArrayList<String> tri){
        HashMap<String,Integer> occurences = new HashMap<String, Integer>();
        ArrayList<String> c = new ArrayList<>(commun);
        for (int i=1;i<c.size();i++){ // iverser clef/valeur et chercher sur le net comment trié map par valeurs
            String mot = c.get(i);
            Integer compteur = 0;
            for (int j=0;j<tri.size();j++){
                if (t.trigrams.get(tri.get(j)).contains(mot)){compteur++;}
            }
            occurences.put(mot,compteur);
        }
        List<Map.Entry<String,Integer>> list = new LinkedList<Map.Entry<String, Integer>>(occurences.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return list;
    }

    public ArrayList<String> getTrigrams(String word){
        ArrayList<String> tri = new ArrayList<>();
        for (int j=0;j<word.length()-2;j++){
            ArrayList<String> liste = new ArrayList<String>();
            String tr = word.substring(j,j+3);
            tri.add(tr);
        }
        return tri;
    }
}