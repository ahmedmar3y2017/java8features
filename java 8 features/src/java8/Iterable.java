/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java8;

import java.util.Objects;
import java.util.function.Consumer;

/**
 *
 * @author ahmed
 */
public interface Iterable<T> {

    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
//        for (T t : this) {
//            action.accept(t);
//        }
    }

    default void ahmed() {

        System.out.println("Done ya man");
    }

    public void done();

}

class aa implements Iterable<Object> {

    @Override
    public void ahmed() {

        System.out.println("Done ya man");
    }

    public static void main(String[] args) {
        aa aa = new aa();
        aa.ahmed();
        aa.done();
    }

    @Override
    public void done() {
        System.out.println("This is Done ... ");
    }

}
