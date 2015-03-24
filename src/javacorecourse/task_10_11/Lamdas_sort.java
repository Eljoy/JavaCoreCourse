package javacorecourse.task_10_11;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Home on 05.12.2014.
 */
public class Lamdas_sort {



        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            LinkedList<String> list1 =  new LinkedList<>();
            LinkedList<String> list2 =  new LinkedList<>();
            String s = scanner.nextLine();

            while (true) {
                if(s.equals("")) break;
                list1.add(s);
                list2.add(s);
                s = scanner.nextLine();
            }
            Collections.sort(list1, (a, b) ->  a.compareToIgnoreCase(b));
            Collections.sort(list2, (a, b) -> b.length() - a.length());

            System.out.println("List sorted ignoring case: ");
            list1.forEach(System.out::println);

            System.out.println("List sorted by length: ");
            list2.forEach(System.out::println);
        }
    }

