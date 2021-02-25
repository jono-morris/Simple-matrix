public class ColumnVector {

    private Matrix matrix;
    
    public ColumnVector(int [] col) {
        int[][] tmp = new int[col.length][1];
        for(int i = 0; i < col.length; i++) {
            tmp[i][0] = col[i];
        }
        this.matrix = new Matrix(tmp);
    }
    
    public String toString() {
        return matrix.toString();
    }
    
    public static void main(String[] args) throws InvalidDimentionException {
      ColumnVector C = new ColumnVector(new int[] {1, 2, 3});
      System.out.println("C \n" + C);
  }
}
