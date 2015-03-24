/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacorecourse.task_2_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Home on 06.11.2014.
 */
public class Tokens
{

    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        while(true) {
            try {
                n = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                System.out.println("The number you have entered is invalid!");
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







