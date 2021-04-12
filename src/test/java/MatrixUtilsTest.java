import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixUtilsTest {
    
    /**
     * Test creation of permutation matrix from permutation. 
     * See https://en.wikipedia.org/wiki/Permutation_matrix
     */
    @Test
    void Permutation() {
        int[][] perm = new int[][]{{1, 1}, {2, 4}, {3, 2}, {4, 5}, {5, 3}};
        Matrix P = MatrixUtils.createPermutation(perm);
        Matrix Pexp = new Matrix(
                new int[][] { {1,0,0,0,0}, {0,0,0,1,0}, {0,1,0,0,0}, {0,0,0,0,1}, {0,0,1,0,0} });
        
        assert(P.equals(Pexp));
    }
    
    @Test
    void PermutationNull() {
        IllegalArgumentException e = 
                assertThrows(
                        IllegalArgumentException.class, 
                        () -> MatrixUtils.createPermutation(null));
        Assertions.assertEquals("invalid permutation vector", e.getMessage());
    }
    
    @Test
    void PermutationInvalid() {
        IllegalArgumentException e = 
                assertThrows(
                        IllegalArgumentException.class, 
                        () -> MatrixUtils.createPermutation(new int[][] {}));
        Assertions.assertEquals("invalid permutation vector", e.getMessage());
    }
}
