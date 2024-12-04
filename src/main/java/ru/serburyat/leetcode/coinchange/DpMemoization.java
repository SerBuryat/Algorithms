package ru.serburyat.leetcode.coinchange;

import java.util.HashMap;

public class DpMemoization {

    public static void main(String[] args) {
        var array = new int[]{2, 1, 5, 3, 7};
        System.out.println("Total: " + new DpMemoization().coinChange(array, 35));
    }

    public int coinChange(int[] coins, int amount) {
        // use memoization (see DP & Memoization)
        // for already counted `amount`
        var memo = new HashMap<Integer, Integer>();
        // by default amount = 0 -> count = 0
        memo.put(0, 0);
        return coinChange(coins, amount, memo) == Integer.MAX_VALUE ? -1 : memo.get(amount);
    }

    private int coinChange(int[] coins, int amount, HashMap<Integer, Integer> memo) {
        // if `amount` already counted -> return `count`
        if(memo.containsKey(amount))
            return memo.get(amount);

        // use `MAX_VALUE` instead`-1` to use `Math.min()`
        var min = Integer.MAX_VALUE;
        // go through all `coins[]` for this `amount`
        for(int coin : coins) {
            // can't allow negative `amount`
            var count = coin > amount
                    ? Integer.MAX_VALUE
                    : coinChange(coins, amount - coin, memo);

            // if not `MAX_VALUE`( or `-1`) -> increment count
            if(count != Integer.MAX_VALUE) {
                count++;
            }

            // get `min` value for every `coin`
            min = Math.min(min, count);
        }

        // memo this `amount`
        memo.put(amount,min);

        return min;
    }

}
