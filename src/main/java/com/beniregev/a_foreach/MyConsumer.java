package com.beniregev.a_foreach;

import java.util.function.Consumer;

/**
 * Consumer for {@link Java8ForEachExample} class
 * @author Binyamin Regev
 * @since 1.8
 */
public class MyConsumer implements Consumer<Integer> {
    public void accept(Integer intNumber) {
        System.out.println("Consumer implements value: " + intNumber);
    }
}
