import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        String str = "sas";
        int[][] matrix = {{9,7,4,5}, {1,6,2,-6}, {12,20,2,0}, {-5,-6,7,-2}};
        int[] first;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == 0)
                    list.add(matrix[i][j]);
                else if (i == matrix.length - 1)
                    list.add(matrix[i][j]);
                else if (j == 0)
                    list.add(matrix[i][j]);
                else if (j == matrix.length - 1)
                    list.add(matrix[i][j]);
            }
        }
        Collections.sort(list);
        System.out.println(list);
    }
}
