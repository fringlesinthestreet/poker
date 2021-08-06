package org.poker.pokerGauss.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyRange implements Iterable<Integer> {

        private final int limit;
        private final int start;

        public MyRange(int limit) {
            this.limit = limit;
            this.start = 0;
        }

        public MyRange(int start, int limit) {
            this.limit = limit;
            this.start = start;
        }

        @Override
        public Iterator<Integer> iterator() {
            final int max = limit;
            return new Iterator<Integer>() {

                private int current = start;

                @Override
                public boolean hasNext() {
                    return current < max;
                }

                @Override
                public Integer next() {
                    if (hasNext()) {
                        return current += 1;
                    } else {
                        throw new NoSuchElementException("Range reached the end");
                    }
                }
            };
        }
}
