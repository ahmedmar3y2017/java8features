/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author ahmed
 */
public class functions {
    
    Predicate<employee> predicate = (emp) -> {
        if (emp.getUsername().equals("ahmed")) {
            
            return true;
        } else {
            return false;
        }
    };
    
    static Predicate<employee> number = (emp) -> {
        if (emp.getPassword().startsWith("123")) {
            return true;
        } else {
            return false;
        }
        
    };
    Predicate<String> ss = (s) -> s.isEmpty();
    
    Consumer<employee> xonConsume = (emp) -> System.out.println("Done ya man : " + emp);
    Consumer<employee> Consumer = (emp) -> persist(emp);
    
    public void testConsume(employee em) {
        xonConsume.accept(em);
        Consumer.accept(em);
    }
    
    public static void main(String[] args) {
        
        new functions().testConsume(new employee(1, "ahmed", "123"));
    }
    
    private void persist(employee emp) {
        
        System.out.println("Done Consume" + emp);
        
    }
    
}
