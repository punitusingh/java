package algorithm.dynamic;

public class CoinCombiDP {


    public static  long ways(int money, int[] coins){


        //take an combinations array of size money + 1, to keep all the amount
        //put 1 in 0th item
        long[] combinations = new long[money+1];
        combinations[0] = 1;
        //loop over all the coins you have
        //see how your coins will contribute to that amount

        //combinations[amount] = combinations[amount] + combinations[amount - coin]

        for(int i=0; i < coins.length; i++){
            int coin=coins[i];

            for(int amount=1;amount<combinations.length;amount++){
                //if coin is less then equal to amount then only, it will affect that amount
                if(amount >= coin){
                    combinations[amount] += combinations[amount - coin];
                }
            }

        }

        return combinations[money];

    }


    public static void main(String[] args) {
        System.out.println(ways(250,new int[]{41,34,46,9,37, 32, 42, 21, 7, 13, 1, 24, 3, 43, 2, 23, 8, 45, 19, 30, 29, 18, 35, 11}));
    }
}
