package ru.serburyat.leetcode.fibonacci;

public class Recursion {

    public static void main(String[] args) {
        var n = 40; // 102334155
        var fib = new Recursion().fib(n);
        System.out.printf("Fib for '%s' = '%s'", n, fib);
    }

    public long fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

}
