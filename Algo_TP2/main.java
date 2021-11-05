import java.io.IOException;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        double debut = System.nanoTime();
        Reader miniDico = new Reader("files/minidico.txt");
        Reader dico = new Reader("files/dico.txt");
        Reader fautes = new Reader("files/fautes.txt");
        Levenstein L = new Levenstein("algorithmique", "logarytmique");
        Trigrams t1 = new Trigrams(dico);
        //Correction c1 = new Correction("<abbatage>",t1, fautes.dico);
        correctionTest ct1 = new correctionTest("abbréviation",t1);
        double fin = System.nanoTime();
        double temps = (fin - debut)/1000000000;
        //System.out.println(c1.corrections);
        System.out.println(ct1.correction);
        System.out.println("le temps mis est : " + temps);
        System.out.println("le nombre de corrections à faire est : " + L.compteur);

        System.out.println(dico.test("<chauve>"));

        System.out.println(t1.trigrams.get("jul"));

        System.out.println(System.nanoTime());

        HashMap<String,Integer> map = new HashMap<>();
        map.put("jul",2);
        map.put("koba",3);
        map.put("nekfeu",1);
        map.put("alors",4);
        List<Map.Entry<String,Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        for (int i=0;i< list.size();i++){
            System.out.println(list.get(i).getValue());
        }

        /*for (Map.Entry<String,Integer> item: list){
            System.out.println(item);
        }*/


/*        String w1 = "<bonjour>";
        String w2 = "<bonheur>";
        String w3 = "<jul>";
        String w4 = "<julien>";
        for (int i=0; i<w2.length()-2;i++){
            System.out.println(w2.substring(i,i+3));
        }
        ArrayList<String> words = new ArrayList<String>();
        words.add(w1);
        words.add(w2);
        words.add(w3);
        words.add(w4);
        HashMap<String,ArrayList<String>> trigrams = new HashMap<>();
        ArrayList<ArrayList<String>> tri1 = new ArrayList<>();
        for (int i=0;i<words.size();i++){
            String word = words.get(i);
            ArrayList<String> tri = new ArrayList<String>();
            //ArrayList<String> liste = new ArrayList<String>();
            for (int j=0;j<word.length()-2;j++){
                String tr = word.substring(j,j+3);
                if (trigrams.keySet().contains(tr)==false){
                    ArrayList<String> liste = new ArrayList<String>();
                    trigrams.put(tr,liste);}
                //trigrams.put(tr,liste);
                //else {trigrams.put(tr,liste);}
                trigrams.get(tr).add(word);
            }
            //for (int k=0;k<tri.size();k++){trigrams.get(tri.get(k)).add(word);}
        }
        for (int i=0;i<words.size();i++){
            ArrayList<String> tri = new ArrayList<String>();
            String word = words.get(i);
            for (int j=0;j<word.length()-2;j++){
                ArrayList<String> liste = new ArrayList<String>();
                String tr = word.substring(j,j+3);
                tri.add(tr);
            }
            for (int k=0;k<tri.size();k++){trigrams.get(tri.get(k)).add(word);}
        }



        System.out.println("clefs : " + trigrams.keySet());
        System.out.println("values : " + trigrams.values());
        System.out.println("test : " + trigrams.get("<bo"));
        trigrams.get("<bo").add("<bonjour>");
        System.out.println("test2 : " + trigrams.get("<bo"));*/

    }
}