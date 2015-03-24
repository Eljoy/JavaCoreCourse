package javacorecourse.task_16;

/**
 * Created by Home on 13.12.2014.
 */
public class Atkins {
    private int  _limit, count = 0;
    private double sqrt;
    private boolean[] IsPrimes;
    public Atkins (int n) {
        _limit = n;
        IsPrimes = new boolean[_limit + 1];
        sqrt = Math.sqrt(_limit);
    }
    public void findPrimes () {
        for (int x = 1; x <= sqrt; x++)
            for (int y = 1; y <= sqrt; y++)
            {
                int x2 = x * x;
                int y2 = y * y;
                int n = 4 * x2 + y2;
                if (n <= _limit && (n % 12 == 1 || n % 12 == 5))
                    IsPrimes[n] ^= true;

                n -= x2;
                if (n <= _limit && n % 12 == 7)
                    IsPrimes[n] ^= true;

                n -= 2 * y2;
                if (x > y && n <= _limit && n % 12 == 11)
                    IsPrimes[n] ^= true;
            }

        for (int n = 5; n <= sqrt; n += 2)
            if (IsPrimes[n])
            {
                int s = n * n;
                for (int k = s; k <= _limit; k += s)
                    IsPrimes[k] = false;
            }
        IsPrimes[2] = IsPrimes[3] = true;
        show();
        }
    private void show () {
        for (int i = 0; i <= _limit; i++) {
            if(IsPrimes[i]) {
                  count++;
             if(count == 1000000) System.out.println(i);
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        new Atkins(100000000).findPrimes();
    }
 }

