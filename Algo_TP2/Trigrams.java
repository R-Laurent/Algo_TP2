import java.util.ArrayList;
import java.util.HashMap;

public class Trigrams {
    Reader reader;
    HashMap<String,String[]> trigrams = new HashMap<>();
    public Trigrams(){
        ArrayList<String> dico = new ArrayList<String>(reader.dico);
        //Object[] dico = reader.dico.toArray();
        for (int i=0; i<dico.size(); i++){
            for (int j=0; j<dico.get(i).length()-2;j++){

            }
        }
    }
}