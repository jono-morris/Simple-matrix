import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import exception.InvalidDimentionException;

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
    
    /** Test addition of two matrices */
    @Test
    void add() {
        Matrix A = new Matrix(new int[][] { {1, 3, 1}, {1, 0, 0} });
        Matrix B = new Matrix(new int[][] { {0, 0, 5}, {7, 5, 0} });
        Matrix Exp = new Matrix(new int[][] { {1, 3, 6}, {8, 5, 0} });
        assert A.add(B).equals(Exp);
    }
    
    /** Dimensions of added matrices must be the same */
    @Test
    void addFailDim() {
        Matrix A = new Matrix(new int[2][2]);
        Matrix B = new Matrix(new int[2][3]);
        InvalidDimentionException e = 
                assertThrows(
                        InvalidDimentionException.class, 
                        () -> A.add(B));
        Assertions.assertEquals("matrix dimensions must be equal", e.getMessage());
    }
    
    @Test
    void scalarMult() {
        Matrix A = new Matrix(new int[][] { {1, 8, -3}, {4, -2, 5} });
        Matrix Exp = new Matrix(new int[][] { {2, 16, -6}, {8, -4, 10} });
        assert A.scalarMult(2).equals(Exp);
    }
    
    @Test
    void mult() {
        Matrix A = new Matrix(new int[][] { {2, 3, 4}, {1, 0, 0} });
        Matrix B = new Matrix(new int[][] { {0, 1000}, {1, 100}, {0, 10} });
        Matrix Exp = new Matrix(new int[][] { {3, 2340}, {0, 1000} });
        assert A.mult(B).equals(Exp);
    }
    
    @Test
    void multInvalidDim() {
        Matrix A = new Matrix(new int[2][3]);
        Matrix B = new Matrix(new int[2][3]);
        InvalidDimentionException e = 
                assertThrows(
                        InvalidDimentionException.class, 
                        () -> A.mult(B));
        Assertions.assertEquals(
                "illegal dimension this dim 2 x 3, other dim must be 3 x 2 but was 2 x 3)", 
                e.getMessage());
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
