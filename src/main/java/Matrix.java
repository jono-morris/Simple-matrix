
import java.util.Arrays;

import exception.InvalidDimentionException;
import function.TriFunction;


/**
 * Matrix implementation experiment.
 *
 */
public class Matrix {

    private int[][] mat;
    private int m;
    private int n;

    public Matrix(int[][] mat) {
        this.mat = mat;
        this.m = mat.length;
        this.n = mat[0].length;
    }

    public Matrix add(Matrix other) throws InvalidDimentionException {
        if (this.m != other.m || this.n != other.n) {
            throw new InvalidDimentionException("matrix dimensions must be equal");
        }
        int[][] tmp = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                tmp[r][c] = mat[r][c] + other.mat[r][c];
            }
        }
        return new Matrix(tmp);
    }

    public Matrix scalarMult(int multiplier) {
        Matrix copy = new Matrix(this.mat);
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                copy.mat[r][c] *= multiplier;
            }
        }
        return copy;
    }

    private void applyTriFunction(int [][] tmp, TriFunction tf) {
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                tmp[c][r] = tf.apply(mat, r, c);
            }
        }
    }
    
    public Matrix transpose() {
        int[][] tmp = new int[n][m];        
        applyTriFunction(tmp, (int[][] mat, int r, int c) -> {return mat[r][c];});
        return new Matrix(tmp);
    }

    public Matrix mult(final Matrix other) throws InvalidDimentionException {
        if (this.m != other.n || this.n != other.m) {
            throw new InvalidDimentionException(
                    String.format("" + "illegal dimension this, dim %s x %s, other dim must be %s x %s but was %s x %s)",
                            m, n, n, m, other.m, other.n));
        }
        int[][] tmp = new int[this.m][this.m];
        for (int r = 0; r < this.m; r++) {
            for (int c = 0; c < this.m; c++) {
                tmp[r][c] = sum(this, other, r, c);
            }
        }
        return new Matrix(tmp);
    }

    private int sum(Matrix a, Matrix b, int r, int c) {
        int sum = 0;
        for (int i = 0; i < a.n; i++) {
            sum += a.mat[r][i] * b.mat[i][c];
        }
        return sum;
    }

    public static Matrix copy(Matrix other) {
        int [][] tmp = new int[other.m][other.n];
        for(int i = 0; i < other.m; i++) {
            tmp[i] = Arrays.copyOf(other.mat[i], other.m + 1);
        }
        return new Matrix(tmp);
    }

    public RowVector getRow(int rowNum) {
        return new RowVector(this.mat[rowNum - 1]);
    }
    
    public Matrix multiplyRow(final int val, int rowNum) {
        Matrix tmp = new Matrix(this.mat);
        for(int j = 0; j < tmp.n; j++) {
            tmp.mat[rowNum - 1][j] = this.mat[rowNum - 1][j] * val;
        }
        return tmp;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < mat.length; i++) {
            sb.append("  ");
            for (int j = 0; j < mat[0].length; j++) {
                sb.append(mat[i][j]);
                sb.append("  ");
            }
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Matrix) {
            Matrix other = (Matrix) o;
            if (this.m != other.m || this.n != other.n) {
                return false;
            }
            for(int r = 0; r < m; r++) {
                if (!Arrays.equals(this.mat[r], other.mat[r])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) throws InvalidDimentionException {

//      Matrix A = new Matrix(new int[][] { { 1, 2, 3 }, { 1, 0, 0 } });
//      System.out.println("A\n" + A);
//
//      Matrix A_copy = Matrix.copy(A);
//      System.out.println("A copy\n" + A_copy);
//      
//          A = A.multiplyRow(2, 1);
//      
//          System.out.println("A\n" + A);
//          System.out.println("A copy\n" + A_copy);
//          
//          
//          System.out.println("A row 1\n" + A.getRow(1));

//      Matrix B = new Matrix(new int[][] { { 0, 0, 5 }, { 7, 5, 0 } });


//      System.out.println("B\n" + B);
//      System.out.println("A + B\n" + A.add(B));
//      System.out.println("A Tr\n" + A.transpose());
//      System.out.println("2 * A\n" + A.scalarMult(2));
      
//      ColumnVector C = new ColumnVector(new int[] {1, 2, 3});
//      System.out.println("C \n" + C);
      
//      Matrix A = new Matrix(new int[][] { { 2, 3, 4 }, { 1, 0, 0 } });
//      Matrix B = new Matrix(new int[][] { { 0, 1000 }, { 1, 100 }, { 0, 10 } });
//      System.out.println("A * B \n" + A.mult(B));
      
  }
    
}