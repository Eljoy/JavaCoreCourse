package javacorecourse.task_10_11;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Home on 04.12.2014.
 */
class  NonRegComp implements Comparator <String> {
    public int compare (String a , String b) {
        return a.compareToIgnoreCase(b);
    }
}

class LengthComp implements  Comparator <String> {
    public int compare(String a, String b) {
        return b.length() - a.length();
    }

}
public class modificated_sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> set1 = new TreeSet<String>(new NonRegComp());
        TreeSet<String> set2 = new TreeSet<String>(new LengthComp());
        String s = scanner.nextLine();

        while (true) {
            if(s.equals("")) break;
            set1.add(s);
            set2.add(s);
            s = scanner.nextLine();
        }
        System.out.println("List sorted by NonregComp'arator");
        set1.forEach(System.out::println);
        System.out.println("List sorted by LengthComp'arator");
        set2.forEach(System.out::println);

    }
   }

