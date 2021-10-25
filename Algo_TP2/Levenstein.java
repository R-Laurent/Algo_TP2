public class Levenstein {

    int compteur;

    public Levenstein(String s1,String s2){
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        int[][] matrice = new int[s1Array.length][s2Array.length];

        for (int i=0; i<s1Array.length;i++){
            for (int j=0; j<s2Array.length;j++){
                if (s2Array[j] == s1Array[i] && j>0 && i>0 ) {matrice[i][j] = min(matrice[i][j-1],matrice[i-1][j-1],matrice[i-1][j]);}
                if (s2Array[j] != s1Array[i] && j>0 && i>0 ){matrice[i][j] = min(matrice[i][j-1],matrice[i-1][j-1],matrice[i-1][j]) + 1;}
                if (s2Array[j] != s1Array[i] && j>0 && i==0){ matrice[i][j]=matrice[i][j-1]+1;}
                if (s2Array[j] != s1Array[i] && j==0 && i>0){matrice[i][j]=matrice[i-1][j]+1;}
            }
        }
        compteur =  + matrice[s1Array.length-1][s2Array.length-1];
    }

    public int min(int a, int b, int c){
        return Math.min(a,Math.min(b,c));
    }

}
