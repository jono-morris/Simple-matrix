public class ColumnVector {

    private DimensionState dim;

    public ColumnVector(int [] col) {
        int[][] tmp = new int[col.length][1];
        for(int i = 0; i < col.length; i++) {
            tmp[i][0] = col[i];
        }
        this.dim = new DimensionState(tmp);
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
        if (o instanceof ColumnVector) {
            ColumnVector other = (ColumnVector) o;
            return this.dim.equals(other.dim);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return dim.hashCode();
    }
}
