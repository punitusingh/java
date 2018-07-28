package algorithm.recursive;

public class AmountSubset {


    static int noOfSubsets(int[] coins, int amount, int coinIndex){

        if(amount == 0 ) return 1;
        if(amount< 0) return 0;
        if(coinIndex >= coins.length ) return 0;
        return noOfSubsets(coins, amount, coinIndex+1 )
                + noOfSubsets(coins, amount - coins[coinIndex], coinIndex+1 );
    }

    static int noOfSubsetsIterative(int[] coins, int amount){
        int[][] matrix=new int[coins.length][amount+1];

        for(int rowCoin=0;rowCoin<coins.length;rowCoin++){
            int coin = coins[rowCoin];
            for(int colAmount=0; colAmount<=amount; colAmount++){
                if(colAmount == coin){
                    if(rowCoin>0){
                        matrix[rowCoin][colAmount] = matrix[rowCoin - 1][colAmount] + 1;
                    }else{
                        matrix[rowCoin][colAmount] = 1;
                    }

                }else if(colAmount < coin && rowCoin>0) {
                    matrix[rowCoin][colAmount] = matrix[rowCoin - 1][colAmount];
                }else if(colAmount > coin && rowCoin>0){
                    matrix[rowCoin][colAmount] += matrix[rowCoin-1][colAmount - coin];
                }
              //  System.out.printf("\ncolAmount===> %d, coin==> %d\n",colAmount,coin);
               // printArray(matrix[rowCoin]);
            }
         //   System.out.println();
        }

        return matrix[coins.length-1][amount];
    }

    static void printArray(int[] array){
       for(int i=0;i<array.length;i++){
           System.out.print(array[i]+ " ");
       }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] coins=new int[]{2,4,6,10};
        int amount=4;
      //  System.out.println(noOfSubsets(coins, amount,0));
        System.out.println(noOfSubsetsIterative(coins, amount));
    }
}
