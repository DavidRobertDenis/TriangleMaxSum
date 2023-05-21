import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TriangleMaxSum {
    public static int findMaxSum(int[][] triangle) {
        int n = triangle.length;

        // Inițializăm o matrice auxiliară pentru a stoca sumele parțiale
        int[][] maxSum = new int[n][n];

        // Copiem ultimul rând al triunghiului în matricea auxiliară
        for (int i = 0; i < n; i++) {
            maxSum[n - 1][i] = triangle[n - 1][i];
        }

        // Calculăm sumele maxime pentru fiecare element din triunghi
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // Alegem suma maximă dintre cea de pe diagonala dreapta și cea de sub diagonala dreapta
                maxSum[i][j] = triangle[i][j] + Math.max(maxSum[i + 1][j], maxSum[i + 1][j + 1]);
            }
        }

        // Returnăm suma maximă la vârful triunghiului
        return maxSum[0][0];
    }

    public static List<Integer> findMaxSumPath(int[][] triangle) {
        int n = triangle.length;

        // Inițializăm o listă pentru a stoca numerele care alcătuiesc suma maximă
        List<Integer> maxSumPath = new ArrayList<>();

        // Copiem vârful triunghiului în listă
        maxSumPath.add(triangle[0][0]);

        int currentRow = 0;
        int currentCol = 0;

        // Parcurgem triunghiul de sus în jos, adăugând numerele cu suma maximă în listă
        while (currentRow < n - 1) {
            int nextLeft = triangle[currentRow + 1][currentCol];
            int nextRight = triangle[currentRow + 1][currentCol + 1];

            // Alegem suma maximă dintre cea de pe diagonala dreapta și cea de sub diagonala dreapta
            if (nextLeft > nextRight) {
                maxSumPath.add(nextLeft);
                currentCol = currentCol;
            } else {
                maxSumPath.add(nextRight);
                currentCol = currentCol + 1;
            }

            currentRow = currentRow + 1;
        }

        return maxSumPath;
    }

    public static void main(String[] args) {
        int[][] triangle = {
                {1},
                {2, 3},
                {4, 5, 6},
                {7, 8, 9, 10}
        };

        int maxSum = findMaxSum(triangle);
        List<Integer> maxSumPath;
    }
}