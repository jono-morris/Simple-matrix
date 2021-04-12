
public class MatrixUtils {

    public static Matrix identity(int n) {
        int [][] tmp = new int[n][n];
        for(int i = 0; i < n; i++) {
            tmp[i][i] = 1;
        }
        return new Matrix(tmp);
    }
    
    /**
     * Create a permutation matrix from an array of translation elements.
     * Note, the translation matrix uses 1 based indexing, i.e. the 
     * first element starts at 1.
     * 
     * @param perm the translation for each element
     * @return the create permutation matrix
     */
    public static Matrix createPermutation(int [][] perm) {
        if (perm == null || perm.length == 0) {
            throw new IllegalArgumentException("invalid permutation vector");
        }
        int [][] tmp = new int[perm.length][perm.length];        
        for(int i = 0; i < perm.length; i++) {
            tmp[perm[i][0] - 1][perm[i][1] - 1] = 1;
        }
        return new Matrix(tmp);
    }
}
