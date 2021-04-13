
public class MatrixUtils {

    /**
     * Creates an identity matrix of the specified size.
     * See https://en.wikipedia.org/wiki/Identity_matrix
     * 
     * @param n the size of the Identity matrix, n by n square
     * @return the created matrix
     */
    public static Matrix identity(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("invalid matrix size");
        }
        int [][] tmp = new int[n][n];
        for(int i = 0; i < n; i++) {
            tmp[i][i] = 1;
        }
        return new Matrix(tmp);
    }
    
    /**
     * Create a permutation matrix from a permutation.
     * See https://en.wikipedia.org/wiki/Permutation_matrix
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
