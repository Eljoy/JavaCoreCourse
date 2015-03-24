package javacorecourse.task_10_11;

import javafx.collections.transformation.SortedList;

import java.util.*;

/**
 * Created by Home on 18.11.2014.
 */
public class sort {


    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        LinkedList<String> list = new LinkedList<>();
        String s = scanner.nextLine();

        while (true) {
            if(s.equals("")) break;
            list.add(s);
            s = scanner.nextLine();
        }
        Collections.sort(list);

        list.forEach(System.out::println);

    }
}