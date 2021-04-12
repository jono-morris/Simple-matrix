import exception.InvalidDimentionException;

public class RowVector {
    
    private Matrix matrix;
    
    public RowVector(int [] row) {
        int[][] tmp = new int[1][row.length];
        for(int j = 0; j < row.length; j++) {
            tmp[0][j] = row[j];
        }
        this.matrix = new Matrix(tmp);
    }
    
    public String toString() {
        return matrix.toString();
    }
    
    public static void main(String[] args) throws InvalidDimentionException {
      RowVector R = new RowVector(new int[] {4, 5, 6});
      System.out.println("R \n" + R);
  }
    
}
