import org.junit.jupiter.api.Test;

public class MatrixTest {

    @Test
    void MatrixEquals() {
        Matrix A = new Matrix(
                new int[][] { { 1, 2, 3 }, { 1, 0, 0 } });
        Matrix B = new Matrix(
                new int[][] { { 1, 2, 3 }, { 1, 0, 0 } });
        Matrix C = new Matrix(
                new int[][] { { 1, 2, 3 }, { 1, 0, 0 } });
        
        assert(!A.equals(null));
        assert(A.equals(A));
        assert(A.equals(B) && B.equals(A));
        assert(A.equals(C) && B.equals(C));
    }
    
    @Test
    void MatrixNotEquals() {
        Matrix A = new Matrix(
                new int[][] { { 1, 2, 3 }, { 1, 0, 0 } });
        Matrix B = new Matrix(
                new int[][] { { 1, 0, 0 }, { 1, 2, 3 } });
        
        assert(!A.equals(null));
        assert(!A.equals(B));
    }
}
