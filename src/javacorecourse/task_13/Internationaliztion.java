package javacorecourse.task_13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Тема: Интернационализация.
 Задание 13 (2 балла): Изменить программу из задания 7 так, чтобы язык выводимых сообщений
 зависел от настроек, заданных в операционной системе.

 */
public class Internationaliztion {
    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", Locale.getDefault());
        System.out.println(messages.getString("greetings"));
        while(true) {
            try {
                n = Integer.parseInt(reader.readLine());
            } catch (Exception e) {

                System.out.println(messages.getString("warning"));
                continue;
            }
            break;
        }
            {

                int snake[][] = new int[n][];
                for (int i = 0; i < n; i++)
                    snake[i]=new int[n];
                int max = n*n-1;
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
                for(int i = 0; i < m; i++) {
                    for(int j = 0; j < m; j++){
                        System.out.print(snake[i][j]+((snake[i][j]>9) ? " " :"  "));
                    }
                    System.out.println();
                }
            }

        }
    }


