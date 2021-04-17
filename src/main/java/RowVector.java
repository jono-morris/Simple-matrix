public class RowVector {

    private DimensionState dim;

    public RowVector(int[] row) {
        int[][] tmp = new int[1][row.length];
        for (int j = 0; j < row.length; j++) {
            tmp[0][j] = row[j];
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
        if (o instanceof RowVector) {
            RowVector other = (RowVector) o;
            return this.dim.equals(other.dim);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return dim.hashCode();
    }
}
