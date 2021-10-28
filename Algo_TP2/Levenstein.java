public class Levenstein {

    int compteur;

    public Levenstein(String s1,String s2){

        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        System.out.println("longuer s1 : " + s1.length());
        System.out.println("longuer s2 : " + s2.length());
        int[][] matrice = new int[s1Array.length+1][s2Array.length+1];

        for (int i=0;i<matrice[0].length;i++){
            matrice[0][i] = i;
            System.out.println("la première ligne  : " + matrice[0][i]);
        }
        for (int i=0; i<s1Array.length+1;i++){
            matrice[i][0] = i;
            System.out.println("les premières cas de la première colonne : " + matrice[i][0]);
        }

        for (int i=0; i<s1Array.length;i++){
            for (int j=0; j<s2Array.length;j++){
                if (s2Array[j] == s1Array[i] && j>0 && i>0 ) {matrice[i][j] = min(matrice[i][j-1],matrice[i-1][j-1],matrice[i-1][j]);
                    System.out.println("cas 1 : " + "i : " + i + " j : " + j);} //cas 1
                if (s2Array[j] != s1Array[i] && j>0 && i>0 ){matrice[i][j] = min(matrice[i][j-1],matrice[i-1][j-1],matrice[i-1][j]) + 1;
                    System.out.println("cas 2 : " + "i : " + i + " j : " + j);} // cas 2
                if (s2Array[j] != s1Array[i] && j>0 && i==0){ matrice[i][j]=matrice[i][j-1]+1;
                    System.out.println("cas 3 : " + "i : " + i + " j : " + j);} // cas 3
                if (s2Array[j] != s1Array[i] && j==0 && i>0){matrice[i][j]=matrice[i-1][j]+1;
                    System.out.println("cas 4 : " + "i : " + i + " j : " + j);} // cas 4

                if (s2Array[j] != s1Array[i] && i==0 && j==0){matrice[i][j]=1;
                    System.out.println("cas 5 : " + "i : " + i + " j : " + j);} // cas 5

                if (s2Array[j] == s1Array[i] && i==0 && j==0){matrice[i][j]=0;
                    System.out.println("cas 6 : " + "i : " + i + " j : " + j);} // cas 6

                System.out.println(matrice[i][j]);
            }
        }
        compteur =  + matrice[s1Array.length][s2Array.length];
    }

    public int min(int a, int b, int c){
        return Math.min(a,Math.min(b,c));
    }

}