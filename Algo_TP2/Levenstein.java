public class Levenstein {

    int compteur;

    public Levenstein(String s1,String s2){
        s1 = "!"+s1;
        s2 = "!"+s2;

        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        int[][] matrice = new int[s1Array.length][s2Array.length];

        for (int i=0;i<matrice[0].length;i++){
            matrice[0][i] = i;
        }
        for (int i=0; i<s1Array.length;i++){
            matrice[i][0] = i;
        }
        int cout;
        for (int i=1; i<s1Array.length;i++){
            for (int j=1; j<s2Array.length;j++){
                if (s2Array[j] == s1Array[i]) { cout = 0;}
                else {cout = 1;}
                matrice[i][j] = min(matrice[i][j-1]+1,matrice[i-1][j-1] + cout ,matrice[i-1][j] + 1);

            }
        }
        compteur = matrice[s1Array.length-1][s2Array.length-1];
    }

    public int min(int a, int b, int c){
        return Math.min(a,Math.min(b,c));
    }

}