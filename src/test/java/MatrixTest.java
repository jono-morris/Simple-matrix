import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MatrixTest {

    /**
     * Testing equals contract
     */
    @Test
    void matrixEquals() {
        Matrix A = new Matrix(
                new int[][] { { 1, 2, 3 }, { 1, 0, 0 } });
        Matrix B = new Matrix(
                new int[][] { { 1, 2, 3 }, { 1, 0, 0 } });
        Matrix C = new Matrix(
                new int[][] { { 1, 2, 3 }, { 1, 0, 0 } });
        
        assert(A.equals(A));
        assert(A.equals(B) && B.equals(A));
        assert(A.equals(C) && B.equals(C));
    }
    
    /**
     * Testing equals contract
     */
    @Test
    void matrixNotEquals() {
        Matrix A = new Matrix(
                new int[][] { { 1, 2, 3 }, { 1, 0, 0 } });
        Matrix B = new Matrix(
                new int[][] { { 1, 0, 0 }, { 1, 2, 3 } });
        
        assert(!A.equals(null));
        assert(!A.equals(B));
    }
    
    @Test
    void transpose() {
        Matrix A = new Matrix(
                new int[][] { { 1, 2, 3 }, { 1, 0, 0 } });
        Matrix ATr = new Matrix(
                new int[][] { { 1, 1 }, { 2, 0 }, { 3, 0 } });
        
        assert A.transpose().equals(ATr);
    }
    
    /**
     * Verify that a permutation matrix is orthogonal.
     */
    @Test
    void isOrthogonal() {
        Matrix P = new Matrix(
                new int[][] { {1,0,0,0,0}, {0,0,0,1,0}, {0,1,0,0,0}, {0,0,0,0,1}, {0,0,1,0,0} });
        assertTrue(P.isOrthogonal());       
    }
}
