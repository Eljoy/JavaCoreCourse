package javacorecourse.task__15;

/**
 * Created by Home on 08.12.2014.
 */
public class Creator implements Runnable {
    S_Queue q;
    Object e;
    Creator(S_Queue q, Object e) {
        this.q = q;
        new Thread(this, "Creator").start();
        this.e = e;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            q.put(e);
        }
    }

}