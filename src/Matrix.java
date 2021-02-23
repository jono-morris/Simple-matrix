
/**
 * Matrix implementation experiment.
 *
 */
public class Matrix {

    int[][] mat;
    int m;
    int n;

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

    public Matrix transpose() {
        int[][] tmp = new int[n][m];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                tmp[c][r] = mat[r][c];
            }
        }
        return new Matrix(tmp);
    }

    public Matrix mult(Matrix other) throws InvalidDimentionException {
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
    
    public static void main(String[] args) throws InvalidDimentionException {

//      Matrix A = new Matrix(new int[][] { { 1, 2, 3 }, { 1, 0, 0 } });
//      Matrix B = new Matrix(new int[][] { { 0, 0, 5 }, { 7, 5, 0 } });

//      System.out.println("A\n" + A);
//      System.out.println("B\n" + B);
//      System.out.println("A + B\n" + A.add(B));
//      System.out.println("A Tr\n" + A.transpose());
//      System.out.println("2 * A\n" + A.scalarMult(2));
      
//      ColumnVector C = new ColumnVector(new int[] {1, 2, 3});
//      System.out.println("C \n" + C);
      
      Matrix A = new Matrix(new int[][] { { 2, 3, 4 }, { 1, 0, 0 } });
      Matrix B = new Matrix(new int[][] { { 0, 1000 }, { 1, 100 }, { 0, 10 } });
      System.out.println("A * B \n" + A.mult(B));
  }
    
}
