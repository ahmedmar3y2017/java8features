/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 *
 * @author ahmed
 */
public class stream {

    static ArrayList<employee> emArrayList = new ArrayList<>();

    public static void main(String[] args) {

        emArrayList.add(new employee(1, "ahmed", "123456"));
        emArrayList.add(new employee(2, "moahmed", "waled"));
        emArrayList.add(new employee(3, "mohamed", "pompa"));

        // stream api 
        List<String> em = emArrayList.stream().filter(mm -> mm.getPassword().startsWith("123")).map(m -> m.getUsername()).collect(toList());
        System.out.println(em);

        List<Integer> list = emArrayList.stream().map(employee::getNumber).collect(toList());

        System.out.println(list);

        // for each
        Arrays.asList("ahmed", "mohamed", "eslam").forEach(employee::print);

        for (employee empp : emArrayList) {

            System.out.println(empp.getUsername());

        }
        System.out.println("-------------------");
        emArrayList.forEach(emm -> {
            System.out.println(emm.getUsername());
        });

    }

}
