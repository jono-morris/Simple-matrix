
/**
 * Matrix implementation experiment.
 *
 */
public class Matrix {

	int [][] mat;
	int m;
	int n;
	
	public Matrix(int [][] mat) {
		this.mat = mat;
		this.m = mat.length;
		this.n = mat[0].length;
	}

	public Matrix add(Matrix other) throws IllegalMatrixOpException {
		if (this.m != other.m || this.n != other.n) {
			throw new IllegalMatrixOpException("matrix dimensions must be equal");
		}
		int [][] tmp = new int[m][n];
		for(int r = 0; r < m; r++) {
			for(int c = 0; c < n; c++) {
				tmp[r][c] = mat[r][c] + other.mat[r][c];
			}
		}
		return new Matrix(tmp);
	}
	
	public Matrix scalarMult(int multiplier) {
		Matrix copy = new Matrix(this.mat);
		for(int r = 0; r < m; r++) {
			for(int c = 0; c < n; c++) {
				copy.mat[r][c] *= multiplier;
			}
		}
		return copy;
	}
	
	public Matrix transpose() {
		int [][] tmp = new int[n][m];
		for(int r = 0; r < m; r++) {
			for(int c = 0; c < n; c++) {
				tmp[c][r] = mat[r][c];
			}
		}
		return new Matrix(tmp);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[\n");
		for(int i = 0; i < mat.length; i++) {
			sb.append("  ");
			for(int j = 0; j < mat[0].length; j++) {
				sb.append(mat[i][j]);
				sb.append("  ");
			}
			sb.append("\n");
		}
		sb.append("]");
		return sb.toString();
	}
	
	public static void main(String[] args) throws IllegalMatrixOpException {

		int[][] m = new int[][] {
			{1, 2, 3},
			{1, 0, 0}
		};
		Matrix A = new Matrix(m);
		

		Matrix B = new Matrix(new int[][] {
			{0, 0, 5},
			{7, 5, 0},
		});
		
		System.out.println("A\n" + A);
		System.out.println("B\n" + B);
		System.out.println("A + B\n" + A.add(B));
		System.out.println("A Tr\n" + A.transpose());
		System.out.println("2 * A\n" + A.scalarMult(2));
	}

}
