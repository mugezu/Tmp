import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 08.09.2016.
 */
public class Main {
    public static void main(String[] arg) throws IOException {

      /*  int[][] matrix={
                {1,4,1,1,4,4,2,3,5,2,5,6,6,6,1},
                {2,1,4,1,6,5,6,2,2,1,6,3,1,3,1},
                {3,5,2,1,5,4,4,1,4,5,2,3,4,5,4},
                {3,1,4,5,5,4,2,4,3,5,2,1,5,5,6},
                {3,5,1,4,2,5,1,5,3,5,4,5,5,3,3},
                {3,1,3,5,4,3,1,3,3,3,3,1,3,3,4}
        };*/
        int[][] matrix = {
                {2, 1, 3, 1, 3, 3, 4, 3, 5, 5, 6, 2, 4, 3, 2},
                {5, 6, 2, 2, 2, 6, 6, 2, 4, 3, 2, 3, 3, 3, 3},
                {4, 2, 2, 4, 3, 1, 1, 6, 2, 2, 3, 4, 5, 5, 3},
                {2, 3, 3, 1, 6, 6, 2, 6, 1, 6, 1, 3, 2, 5, 6},
                {6, 6, 5, 2, 1, 2, 2, 1, 6, 1, 6, 2, 2, 3, 4},
                {6, 6, 3, 3, 1, 6, 5, 4, 2, 2, 1, 2, 6, 6, 5}
        };
        Factories a = new Factories(6, 15);
        a.run(matrix);
        a.showResult();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String aaa = reader.readLine();
    }
}
