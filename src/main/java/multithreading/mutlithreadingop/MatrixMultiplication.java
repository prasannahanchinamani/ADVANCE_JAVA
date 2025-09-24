package multithreading.mutlithreadingop;

public class MatrixMultiplication extends Thread {
    synchronized public void run(int m1[][], int m2[][]) {
        System.out.println("Matrix multiplication Is happening");
        int res[][] = matrixMultiplication(m1, m2);
        System.out.println("Result Matrix:");
        for (int[] row : res) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public int[][] matrixMultiplication(int a[][], int b[][]) {
        int row1 = a.length;   //a X b
        int col1 = a[0].length;
        int row2 = b.length;   // x X y
        int col2 = b[0].length;
        int res[][] = new int[row1][col2];
        if (col1 != row2) {
            System.out.println("Not Multiplication Is Not possible...");
        }
        //a X Y

        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                int sum = 0;
                for (int k = 0; k < col1; k++) {
                    sum += a[i][k] * b[k][j];
                }
                synchronized (res) {
                    res[i][j] = sum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) throws InterruptedException {
        int[][] A = {{1, 2, 3}, {4, 5, 6}};         // 2x3
        int[][] B = {{7, 8}, {9, 10}, {11, 12}};

        int[][] C = {{1, 2}, {4, 5}};         // 2x3
        int[][] D = {{7, 8}, {9, 10}};//3x2
        //res 2x2
        MatrixMultiplication mm = new MatrixMultiplication();
        int[][] sharedRes = new int[A.length][B[0].length]; // shared result array

        // Thread 1
        Thread t1 = new Thread(() -> {
            int[][] res = mm.matrixMultiplication(C,D);
            for (int i = 0; i < res.length; i++)
                for (int j = 0; j < res[0].length; j++)
                    synchronized (sharedRes) {
                        sharedRes[i][j] = res[i][j];
                    }
        });

        // Thread 2 (overlapping writes)
        Thread t2 = new Thread(() -> {
            int[][] res = mm.matrixMultiplication(A, B);
            for (int i = 0; i < res.length; i++)
                for (int j = 0; j < res[0].length; j++)
                    synchronized (sharedRes) {
                        sharedRes[i][j] = res[i][j];
                    }
        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();


        System.out.println("Final Result Matrix (may be inconsistent):");
        for (int[] row : sharedRes) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }
}
