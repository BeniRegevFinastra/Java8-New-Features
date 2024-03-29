package com.beniregev.a_foreach;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.ConcurrentModificationException;

/**
 * <p>
 * Whenever we need to traverse through a Collection, we need to create an {@link Iterator}
 * whose whole purpose is to iterate over and then we have business logic in a loop for each
 * of the elements in the Collection. We might get {@link ConcurrentModificationException} if
 * iterator is not used properly.
 * </p>
 * <p>
 * <div>
 * Java 8 has introduced <i>forEach</i> method in {@link java.lang.Iterable} interface
 * so that while writing code we focus on business logic only. <i>forEach</i> method
 * takes {@link java.util.function.Consumer} object as argument, so it helps in having
 * our business logic at a separate location that we can reuse.
 * </div>
 * <div>
 * Let’s see forEach usage with simple example.
 * </div>
 * </p>
 * <p>
 * Note: The number of lines might increase but <i>forEach</i> method helps in having the logic for
 * iteration and business logic at separate place resulting in higher separation of concern and cleaner
 * code.
 * </p>
 *
 * @author Binyamin Regev
 * @since 1.8
 */
public class Java8ForEachExample {
    public static void main(String[] args) {

        //creating sample Collection
        List<Integer> myList = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) myList.add(i);

        //traversing using Iterator
        Iterator<Integer> it = myList.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println("Iterator Value::" + i);
        }

        //traversing through forEach method of Iterable with anonymous class
        myList.forEach(new Consumer<Integer>() {
            public void accept(Integer t) {
                System.out.println("forEach anonymous class Value::" + t);
            }
        });

        //traversing with Consumer interface implementation
        MyConsumer action = new MyConsumer();
        myList.forEach(action);
    }
}
