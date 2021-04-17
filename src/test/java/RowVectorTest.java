import org.junit.jupiter.api.Test;

public class RowVectorTest {

    @Test
    void rowEquals() {
        RowVector A = new RowVector(new int[] { 1, 2, 3 } );
        RowVector B = new RowVector(new int[] { 1, 2, 3 } );
        RowVector C = new RowVector(new int[] { 1, 2, 3 } );
        assert(A.equals(A));
        assert(A.equals(B) && B.equals(A));
        assert(A.equals(C) && B.equals(C));
    }
    
    /**
     * Testing equals contract
     */
    @Test
    void rowNotEquals() {
        RowVector A = new RowVector(new int[] { 1, 2, 3 } );
        RowVector B = new RowVector(new int[] { 1, 0, 0 } );
        assert(!A.equals(null));
        assert(!A.equals(B));
    }
    
    @Test
    void matrixHashCode() {
        RowVector A = new RowVector(new int[] { 1, 2, 3 } );
        RowVector B = new RowVector(new int[] { 1, 2, 3 } );
        RowVector C = new RowVector(new int[] { 1, 0, 0 } );
        assert A.hashCode() == B.hashCode();
        assert A.hashCode() != C.hashCode();
    }
}
