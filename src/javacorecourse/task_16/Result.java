package javacorecourse.task_16;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 15.12.2014.
 */
public class Result {
    static boolean[] Numbers;
    List <Integer> results = new ArrayList<>();
    static {


    }
    public static void main(String[] args) {

    }

    class Ceive implements Runnable {
        public Ceive () {

        }

        @Override
        public void run() {
            for (int i = 3; i < Numbers.length; i += 2) {
                if (!Numbers[i]) {
                    results.add(i);
                    for (long j = i * (long) i; j < Numbers.length; j += i) {
                        Numbers[(int) j] = true;
                    }
                }
            }
        }
    }
}
