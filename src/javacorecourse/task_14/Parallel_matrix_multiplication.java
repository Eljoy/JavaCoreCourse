package javacorecourse.task_14;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Home on 06.12.2014.
 */
public class Parallel_matrix_multiplication {
    static int[][] res;
    private static int n;
    static {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
    }


    public static void main(String[] args) throws Exception {
        int [][] first_matrix = snake(n);
        int [][] second_matrix = snake(n);
        res = new int[n][n];
        int preset = 0;
        final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
        final int NUMBER_OF_THREADS = (NUMBER_OF_CORES > n) ? n : NUMBER_OF_CORES;
        final int STEP = (n / NUMBER_OF_CORES) == 0 ? n : (n / NUMBER_OF_CORES);
        LinkedList<Thread> list = new LinkedList<>();

        for (int i = 0; i < NUMBER_OF_THREADS; i++){
            if((i == NUMBER_OF_THREADS - 1) && (n % NUMBER_OF_CORES != 0))
                list.add(new Thread(
                        new Matrix_Multiplication(first_matrix, second_matrix, preset, preset + (1 + STEP))));
            else {
                list.add(new Thread(
                        new Matrix_Multiplication(first_matrix, second_matrix, preset, preset + STEP)));
                preset += STEP;
            }
        }
        for (Thread thread : list) {
            thread.start();
        }

        for (Thread thread : list) {
            thread.join();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                System.out.print(res[i][j]+((res[i][j]< 100) ? "   " :"  "));
            }
            System.out.println();
        }
    }

    public static class Matrix_Multiplication implements Runnable  {
        int [] [] first,  second;
        int st, fn;
        Matrix_Multiplication (int [] [] first, int [] [] second, int st, int fn) {
            this.first = first;
            this.second = second;
            this.st = st;
            this.fn = fn;

        }

        @Override
        public void run() {
            try {
                for (int i = st; i < fn; i++) {
                    for (int j = 0; j < n; j++) {
                        for (int s = 0; s < n; s++) {
                            res[i][j] += first[i][s] * second[s][j];
                        }
                    }
                }
            }
            catch (Exception e) {}
        }
    }
    public static int[][] snake(int n) {
        int snake[][] = new int[n][];
        for (int i = 0; i < n; i++)
            snake[i] = new int[n];
        int max = n*n - 1;
        int s = 0;
        int m = n;
        while(s < (m / 2)) {
            for (int j = s; j < n; j++)
                snake[s][j] = max--;

            for (int j = s+1; j < n; j++)
                snake[j][n - 1] = max--;

            for (int j = n - 2; j >= s; j--)
                snake[n - 1][j] = max--;

            for (int j = n - 2; j > s; j--)
                snake[j][s] = max--;
            s++;
            n--;
        }
        return snake;
    }


}




