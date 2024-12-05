package ru.serburyat.leetcode.fibonacci;

public class Loop {

    public static void main(String[] args) {
        var n = 40; // 102334155
        var fib = new Loop().fib(n);
        System.out.printf("Fib for '%s' = '%s'", n, fib);
    }

    public long fib(int n) {
        long[] fibArr = new long[n+1];
        fibArr[0] = 0L;
        fibArr[1] = 1L;
        for (var i = 2; i <= n; i++) {
             fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
        }
        return fibArr[n];
    }

}
