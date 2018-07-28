package algorithm.dynamic;

import java.util.Map;
import java.util.HashMap;

public class Coins {


    public static int ways(int money, int[] coins, int index, Map<String, Integer> memo){
        if(money == 0) return 1;
        if(index >= coins.length) return 0;

        String key=money+"_"+coins[index]; //sum_coin
        if(memo.containsKey(key)){
            System.out.println("memo contains key ::"+key);
            return memo.get(key);
        }
        int amountWithCoin = 0 ;
        int way=0;
        while (amountWithCoin <= money){
            int remaining = money - amountWithCoin;
            amountWithCoin = amountWithCoin + coins[index];
            way = way + ways(remaining, coins, index+1, memo);
        }

        memo.put(key, way);
        System.out.println(memo);
        return way;
    }

    public  static int ways(int n, int[] coins){

         return ways(n, coins, 0, new HashMap<String, Integer>());
    }


    public static void main(String[] args) {
        System.out.println(ways(4,new int[]{1,2,3}));
    }
}
