package javacorecourse.task_16;

import sun.java2d.pipe.SpanShapeRenderer;

import java.util.*;
import java.util.concurrent.*;

/**
 100e - 541
 1000e - 7919
 10000e - 104729
 100000e - 1299709
 1000000e - 15485863
 */
public class Simple_Numbers_Concurrent {
       static boolean[] Simple;
       static  List<Integer> list, checkList;

    public static void main(String[] args) throws  Exception{

        System.out.println(getPrimeNumberByID(1000000));


    }
    public static int getPrimeNumberByID(int id) {
        int n = 0;
        for(int i = 1; i <= 100; i++){
            if((int) Math.ceil(1.25506 * (1000000 * i) / Math.log(1000000 * i)) >= id) {
                n = (int)(1.25506 * 1000000 * i);
                break;
            }
        }
        return getPrimeArray(n).get(id - 1);
    }
    public static List<Integer> getPrimeArray(int n) {

        Simple = new boolean[n];
        list = new ArrayList<>((int) Math.ceil(1.25506 * n / Math.log(n)));
        checkList = eratosthenes_optimized((int)Math.sqrt(n));
        list.addAll(checkList);
        Simple[2] = Simple[3] = Simple[5] = true;
        ExecutorService es = Executors.newFixedThreadPool(8);
        List <Future> s_list = new ArrayList<>(8);

        for (int i = 1; i <= 8; i++) {
            s_list.add(es.submit(new WheelFactorization(i, n / 8)));
        }
        try {
            for (Future<ArrayList <Integer>> future : s_list) {
                list.addAll(future.get());
            }
        }
        catch (Exception e) {e.printStackTrace();}
        es.shutdown();

        Collections.sort(list);

        return list;
    }
    private static class WheelFactorization implements Callable <ArrayList <Integer>> {
        private int step;
        private ArrayList<Integer> inner_list;
        WheelFactorization(int sector, int in_n) {
            inner_list = new ArrayList<>((int) Math.ceil(1.25506 * in_n / Math.log(in_n)));
            if(sector > 8 || sector == 0) return;
            switch (sector){
                case  1 : step = 31;
                   break;
                case  2 : step = 7;
                    break;
                case  3 : step = 11;
                    break;
                case  4 : step = 13;
                    break;
                case  5 : step = 17;
                    break;
                case  6 : step = 19;
                    break;
                case  7 : step = 23;
                    break;
                case  8 : step = 29;
                    break;
            }

        }

        @Override
        public ArrayList <Integer> call() {
            Outer: for(int i = 0; (30 * i + step) < Simple.length; i++){
                for (int j = 0; j < checkList.size(); j++)
                {
                    if(((30 * i + step) % checkList.get(j)) == 0)
                        continue Outer;
                }
                inner_list.add(30 * i + step);
                Simple[30 * i + step] = true;
            }
            return inner_list;
        }
    }

    private static List<Integer> eratosthenes_optimized(int n) {
        boolean[] is_composite = new boolean[n];
        List<Integer> results = new ArrayList<Integer>((int) Math.ceil(1.25506 * n / Math.log(n)));
        results.add(2);
        for (int i = 3; i < is_composite.length; i += 2) {
            if (!is_composite[i]) {
                results.add(i);
                for (long j = i * (long) i; j < is_composite.length; j += i) {
                    is_composite[(int) j] = true;
                }
            }
        }
        return results;
    }
}
