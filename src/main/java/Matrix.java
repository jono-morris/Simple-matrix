
import exception.InvalidDimentionException;
import function.TriFunction;


/**
 * Matrix implementation experiment.
 *
 */
public class Matrix {

    private DimensionState dim;

    public Matrix(int[][] mat) {
        dim = new DimensionState(mat);
    }
    
    public Matrix(Matrix other) {
        this.dim = DimensionState.from(other.dim);
    }
    
    /**
     * Whether or not the current matrix is Orthogonal
     * @return
     */
    public boolean isOrthogonal() {
        if (dim.rows() != dim.cols()) {
            return false;
        }
        return this.mult(this.transpose()).equals(MatrixUtils.identity(dim.cols()));
    }
    
    public Matrix add(Matrix other) throws InvalidDimentionException {
        if (this.dim.rows() != other.dim.rows() || this.dim.cols() != other.dim.cols()) {
            throw new InvalidDimentionException("matrix dimensions must be equal");
        }
        int[][] tmp = new int[dim.rows()][this.dim.cols()];
        for (int r = 0; r < dim.rows(); r++) {
            for (int c = 0; c < dim.cols(); c++) {
                tmp[r][c] = dim.dat()[r][c] + other.dim.dat()[r][c];
            }
        }
        return new Matrix(tmp);
    }

    public Matrix scalarMult(int multiplier) {
        int[][] tmp = new int[dim.rows()][dim.cols()];
        for (int r = 0; r < dim.rows(); r++) {
            for (int c = 0; c < dim.cols(); c++) {
                tmp[r][c] = this.dim.dat()[r][c] *= multiplier;
            }
        }
        return new Matrix(tmp);
    }

    private void applyTriFunction(int [][] tmp, TriFunction tf) {
        for (int r = 0; r < dim.rows(); r++) {
            for (int c = 0; c < dim.cols(); c++) {
                tmp[c][r] = tf.apply(dim.dat(), r, c);
            }
        }
    }
    
    public Matrix transpose() {
        int[][] tmp = new int[dim.cols()][dim.rows()];        
        applyTriFunction(tmp, (int[][] mat, int r, int c) -> {return mat[r][c];});
        return new Matrix(tmp);
    }

    public Matrix mult(final Matrix other) throws InvalidDimentionException {
        if (this.dim.rows() != other.dim.cols() || this.dim.cols() != other.dim.rows()) {
            throw new InvalidDimentionException(
                    String.format("illegal dimension this dim %s x %s, other dim must be %s x %s but was %s x %s)",
                            dim.rows(), dim.cols(), dim.cols(), dim.rows(), other.dim.rows(), other.dim.cols()));
        }
        int[][] tmp = new int[this.dim.rows()][this.dim.rows()];
        for (int r = 0; r < this.dim.rows(); r++) {
            for (int c = 0; c < this.dim.rows(); c++) {
                tmp[r][c] = sum(this, other, r, c);
            }
        }
        return new Matrix(tmp);
    }

    private int sum(Matrix a, Matrix b, int r, int c) {
        int sum = 0;
        for (int i = 0; i < a.dim.cols(); i++) {
            sum += a.dim.dat()[r][i] * b.dim.dat()[i][c];
        }
        return sum;
    }

    public RowVector getRow(int rowNum) {
        return new RowVector(this.dim.dat()[rowNum - 1]);
    }
    
    public Matrix multiplyRow(final int val, int rowNum) {
        Matrix tmp = new Matrix(this.dim.dat());
        for(int j = 0; j < tmp.dim.cols(); j++) {
            tmp.dim.dat()[rowNum - 1][j] = this.dim.dat()[rowNum - 1][j] * val;
        }
        return tmp;
    }
    
    @Override
    public String toString() {
        return dim.toString();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Matrix) {
            Matrix other = (Matrix) o;
            return this.dim.equals(other.dim);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return dim.hashCode();
    }
}
