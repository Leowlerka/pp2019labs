package telematics.nosova.lab1;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.nio.file.Paths;
import java.util.Arrays;

//Чтение из файла матрицы и вывод на экран транспонированной матрицы

public class lab1 {
    public static void main(String[] args) {
        TransArr();
    }

    public static void TransArr() {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("arr.txt"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        int k = 2;
        int n = Integer.parseInt(lines.get(0));
        int m = Integer.parseInt(lines.get(1));
        String[][] arr = new String[n][m];
        for (int i = 0; i < n; i++)
            for (int t = 0; t < m; t++) {
                arr[i][t] = lines.get(k++);
            }
        String[][] trans = new String[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                trans[i][j] = arr[j][i];
            }
        //System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(trans));
    }
}
