package javacorecourse.task_8;

import java.util.ArrayList;

/**
 * Created by Home on 18.11.2014.
 */
public class stack <T> {

    private ArrayList<T> list = new ArrayList<>();

    public void push( T element) {
        list.add(element);
    }

    public T pop()throws StackIsEmptyException{

            if(list.size() == 0) throw new StackIsEmptyException("Stack is Empty!");
            T out = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return out;



    }
    public static class StackIsEmptyException extends Exception {
        StackIsEmptyException(String text) {
            super(text);
        }

    }
}
