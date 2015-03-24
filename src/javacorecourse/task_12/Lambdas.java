package javacorecourse.task_12;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *Задание 12 (5 баллов): Модифицировать программу из задания 10 с использованием лямбда-выражений так,
 * чтобы из введенных строк выбрать те, которые являются корректно написанными автомобильными номерами
 * (например «с493ве 59»), сгруппировать их по региону (последним двум цифрам),
 * для каждого региона вывести количество введенных номеров из этого региона и список этих номеров.
 */

public class Lambdas {
    // "с493ве 59"
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Map<String, List<String>> map = new TreeMap<>();
            LinkedList<String> list = new LinkedList<>();
            Pattern p = Pattern.compile("^\\D\\d{3}\\D{3}\\d{2}$");

            String s = scanner.nextLine();
            while (true) {
                if (s.equals("")) break;
                list.add(s);
                s = scanner.nextLine();
            }
            /**
             * String region = word.substring(word.length() - 2, word.length());
             String auto_number = word.substring(0, word.length() - 3);
            */
             map = list.stream().filter(word -> p.matcher(word).matches()).
                        collect(Collectors.groupingBy(word -> word.substring(word.length() - 2, word.length())));

            for (Map.Entry<String, List<String>> out : map.entrySet()) {
                System.out.println("region: " + out.getKey() + " auto numbers: " + out.getValue() +
                " count: " + out.getValue().size());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}






