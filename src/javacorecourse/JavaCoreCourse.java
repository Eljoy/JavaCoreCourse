/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javacorecourse;

/**
 *
 * @author Home
 */

import java.util.ArrayList;
import java.util.Collections;

public class JavaCoreCourse {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(7);
        list.add(2);
        list.add(1);

        System.out.println(list);

        Collections.reverse(list);

        System.out.println(list);

    }
    
}
