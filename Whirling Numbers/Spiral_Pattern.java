import java.util.Scanner;

public class Spiral_pattern {
    public static int[][] arr;
    static int c = 1;
    static int n;

    public static void Makepattern(int size) {
        if (size <= 0) return;  // Base case to stop recursion

        int i = n - size;
        int j;

        // Fill top row
        for (j = n - size; j < size; j++) {
            arr[i][j] = c++;
        }
        j--;  // Move to the last element in the top row

        // Fill right column
        for (i++; i < size; i++) {
            arr[i][j] = c++;
        }
        i--;  // Move to the last element in the right column

        // Fill bottom row
        for (j--; j >= n - size; j--) {
            arr[i][j] = c++;
        }
        j++;  // Move to the first element in the bottom row

        // Fill left column
        for (i--; i >= n - size + 1; i--) {
            arr[i][j] = c++;
        }

        // Recurse for the next layer
        Makepattern(size - 1);
    }

    public static void Printpattern() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of lines of pattern needed: ");
        n = sc.nextInt();
        if (n <= 0) {
            System.out.println("The number of lines must be a positive integer.");
            return;
        }
        arr = new int[n][n];
        Makepattern(n);
        Printpattern();
    }
}

