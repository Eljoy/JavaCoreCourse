package javacorecourse.task__15;

/**
 * Created by Home on 08.12.2014.
 */
public class out_Class {
    public static void main(String[] args) {
        S_Queue<String> queue = new S_Queue<>(5);
        Creator creator = new Creator(queue, "Tesseract");
        Consumer consumer = new Consumer(queue);

    }
}
