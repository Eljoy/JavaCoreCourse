package javacorecourse.task__15;

/**
 * Created by Home on 08.12.2014.
 */
public class Consumer implements Runnable {
    S_Queue q;
    Consumer(S_Queue q) {
        this.q = q;
        new Thread(this,"Consumer").start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            q.get();
        }
    }
}
