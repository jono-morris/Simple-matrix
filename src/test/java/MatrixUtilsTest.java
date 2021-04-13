import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixUtilsTest {
    
    /**
     * Test creation of 3 by 3 identity matrix.
     */
    @Test
    void identity() {
        Matrix I = MatrixUtils.identity(3);
        Matrix Iexp = new Matrix(new int[][] { {1,0,0}, {0,1,0}, {0,0,1} });
        assert(I.equals(Iexp));
    }
    
    @Test
    void identityZero() {
        IllegalArgumentException e = 
                assertThrows(
                        IllegalArgumentException.class,
                        // identity matrix size zero
                        () -> MatrixUtils.identity(0));
        Assertions.assertEquals("invalid matrix size", e.getMessage());
    }
    
    /**
     * Test creation of permutation matrix from permutation. 
     */
    @Test
    void permutation() {
        int[][] perm = new int[][]{{1, 1}, {2, 4}, {3, 2}, {4, 5}, {5, 3}};
        Matrix P = MatrixUtils.createPermutation(perm);
        Matrix Pexp = new Matrix(
                new int[][] { {1,0,0,0,0}, {0,0,0,1,0}, {0,1,0,0,0}, {0,0,0,0,1}, {0,0,1,0,0} });
        
        assert(P.equals(Pexp));
    }
    
    @Test
    void permutationNull() {
        IllegalArgumentException e = 
                assertThrows(
                        IllegalArgumentException.class, 
                        // null permutation vector
                        () -> MatrixUtils.createPermutation(null));
        Assertions.assertEquals("invalid permutation vector", e.getMessage());
    }
    
    @Test
    void permutationInvalid() {
        IllegalArgumentException e = 
                assertThrows(
                        IllegalArgumentException.class, 
                        () -> MatrixUtils.createPermutation(new int[][] {}));
        Assertions.assertEquals("invalid permutation vector", e.getMessage());
    }
}
