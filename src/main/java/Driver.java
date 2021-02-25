import java.io.PrintStream;
import java.nio.charset.Charset;

public class Driver {

    
//    public static void main(String[] args) throws Exception{
//
//        String unicodeMessage =
//                "\u250c           \u2510\n\u2502  2  3  5  \u2502\n\u2514           \u2518";
//
//        PrintStream out = new PrintStream(System.out, true, "UTF-8");
//        out.println(unicodeMessage);
//    }
    
    
    public static void main(String[] args) throws InvalidDimentionException {

//        Matrix A = new Matrix(new int[][] { { 1, 2, 3 }, { 1, 0, 0 } });
//        Matrix B = new Matrix(new int[][] { { 0, 0, 5 }, { 7, 5, 0 } });

//        System.out.println("A\n" + A);
//        System.out.println("B\n" + B);
//        System.out.println("A + B\n" + A.add(B));
//        System.out.println("A Tr\n" + A.transpose());
//        System.out.println("2 * A\n" + A.scalarMult(2));
        
//        ColumnVector C = new ColumnVector(new int[] {1, 2, 3});
//        System.out.println("C \n" + C);
        
        RowVector R = new RowVector(new int[] {4, 5, 6});
        System.out.println("R \n" + R);
    }
}
