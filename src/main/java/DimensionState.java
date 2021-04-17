import java.util.Arrays;

public class DimensionState {

    private int[][] dat;
    private int m;
    private int n;
    
    protected DimensionState(int[][] dat) {
        if (dat == null || dat.length == 0) {
            throw new IllegalArgumentException("invalid data");
        }
        
        this.m = dat.length;
        this.n = dat[0].length;
        this.dat = copy(dat, m, n);
    }
    
    static protected DimensionState from(DimensionState other) {
        return new DimensionState(other.dat);
    }
    
    private int[][] copy(int[][] mat, int m, int n) {
        int [][] tmp = new int[m][n];
        for(int i = 0; i < m;  i++) {
            tmp[i] = Arrays.copyOf(mat[i], n);
        }
        return tmp;
    }
    
    protected int rows() {
        return m;
    }
    
    protected int cols() {
        return n;
    }
    
    protected int[][] dat() {
        return dat;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < dat.length; i++) {
            sb.append("  ");
            for (int j = 0; j < dat[0].length; j++) {
                sb.append(dat[i][j]);
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
        if (o instanceof DimensionState) {
            DimensionState other = (DimensionState) o;
            if (this.n != other.n || this.m != other.m) {
                return false;
            } 
            for(int r = 0; r < m; r++) {
                if (!Arrays.equals(this.dat[r], other.dat[r])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        int result = 31;
        for(int r = 0; r < m; r++) {
            result = result * 31 + Arrays.hashCode(this.dat[r]);
        }
        return result;
    }
}
