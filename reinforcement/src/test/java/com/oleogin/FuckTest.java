package com.oleogin;

import com.google.common.collect.EvictingQueue;
import org.junit.Test;

public class FuckTest {

    @Test
    public void testName() throws Exception {
        EvictingQueue<String> queue = EvictingQueue.create(4);

        queue.add("1");
        queue.add("2");
        queue.add("3");
        queue.add("4");

        System.out.println(queue);

        System.out.println(queue.peek());

        System.out.println(queue);

        System.out.println(queue.poll());

        System.out.println(queue);

    }
}
