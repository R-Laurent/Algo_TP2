import java.util.ArrayList;
import java.util.HashSet;

public class GetTrigrams {
    HashSet<String> tri = new HashSet<>();

    public  GetTrigrams(String word){
        for (int j=0;j<word.length()-2;j++){
            ArrayList<String> liste = new ArrayList<String>();
            String tr = word.substring(j,j+3);
            tri.add(tr);
        }
    }
}
