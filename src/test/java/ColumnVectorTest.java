import org.junit.jupiter.api.Test;

public class ColumnVectorTest {

    @Test
    void rowEquals() {
        ColumnVector A = new ColumnVector(new int[] { 1, 2, 3 } );
        ColumnVector B = new ColumnVector(new int[] { 1, 2, 3 } );
        ColumnVector C = new ColumnVector(new int[] { 1, 2, 3 } );
        assert(A.equals(A));
        assert(A.equals(B) && B.equals(A));
        assert(A.equals(C) && B.equals(C));
    }
    
    /**
     * Testing equals contract
     */
    @Test
    void rowNotEquals() {
        ColumnVector A = new ColumnVector(new int[] { 1, 2, 3 } );
        ColumnVector B = new ColumnVector(new int[] { 1, 0, 0 } );
        assert(!A.equals(null));
        assert(!A.equals(B));
    }
    
    @Test
    void matrixHashCode() {
        ColumnVector A = new ColumnVector(new int[] { 1, 2, 3 } );
        ColumnVector B = new ColumnVector(new int[] { 1, 2, 3 } );
        ColumnVector C = new ColumnVector(new int[] { 1, 0, 0 } );
        assert A.hashCode() == B.hashCode();
        assert A.hashCode() != C.hashCode();
    }
}
