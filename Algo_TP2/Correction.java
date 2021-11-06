import java.util.*;

public class Correction {
    Trigrams t;
    ArrayList<ArrayList<String>> corrections = new ArrayList<>();
    public Correction(String word, Trigrams t,ArrayList<String> fautes){
        for (int i=0;i<fautes.size();i++){corrections.add(correction1Mot(fautes.get(i),t));}
    }

    public ArrayList<String> correction1Mot(String word, Trigrams t){
        //System.out.println(word);
        ArrayList<String> correction  = new ArrayList<>();
        HashMap<String,Integer> occurences = new HashMap<String, Integer>();
        HashSet<String> c = new HashSet<>();
        ArrayList<String> tri = getTrigrams(word);
        c.add(word);
        for (int i=0;i<tri.size();i++){
            if (t.trigrams.get(tri.get(i))==null){i++;}
            else {
                ArrayList<String> mots = new ArrayList<>(t.trigrams.get(tri.get(i)));
                for (int j = 0; j < mots.size(); j++) {
                    String motCommun = mots.get(j);
                    c.add(motCommun);
                    if (t.trigrams.get(tri.get(i)).contains(motCommun) == true && occurences.containsKey(motCommun) == true) {
                        occurences.computeIfPresent(motCommun,(k,v)-> v+1);
                    }
                    else {Integer compteur = 1; occurences.put(motCommun, compteur);}

                }
            }
        }
        List<Map.Entry<String,Integer>> list = new LinkedList<Map.Entry<String, Integer>>(occurences.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        HashMap<String,Integer> distance = new HashMap<>();

        for (int i=0;i<10;i++){
            Levenstein L = new Levenstein(list.get(i).getKey(),word);
            distance.put(list.get(i).getKey(),L.compteur);
        }
        List<Map.Entry<String,Integer>> lesDistances = new LinkedList<Map.Entry<String, Integer>>(distance.entrySet());
        Collections.sort(lesDistances, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (int i=0;i<5;i++){correction.add(lesDistances.get(i).getKey());}
        return correction;
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