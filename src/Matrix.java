
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
		Matrix a = new Matrix(m);
		

		Matrix b = new Matrix(new int[][] {
			{0, 0, 5},
			{7, 5, 0},
		});
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(a.add(b));
	}

}
