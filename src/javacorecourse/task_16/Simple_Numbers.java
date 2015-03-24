package javacorecourse.task_16;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 15485863
 решето эратосфена
 */
public class Simple_Numbers {

    public static void main(String[] args) {
        System.out.println(eratosthenes_optimized(100000));
    }


    public static List<Integer> eratosthenes_optimized(int n) {
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