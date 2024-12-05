package ru.serburyat.leetcode.fibonacci;

import java.util.stream.IntStream;

public class Stream {

    public static void main(String[] args) {
        new Stream().fib(40);
    }

    public void fib(int n) {
        fibStreamGenerator().limit(n).forEach(System.out::println);
    }

    // fib - 2
    static int last = 0;
    // fib - 1
    static int next = 1;

    private static IntStream fibStreamGenerator() {
        return IntStream.generate(() -> {
           var oldLast = last;
           last = next;
           next = oldLast + next;
           return oldLast;
        });
    }

}
