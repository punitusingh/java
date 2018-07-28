package algorithm.dynamic;

public class Staircase {

    public static int climb(int steps){
        if(steps<0){return 0;}
        if(steps==0){return 1;}
        if(steps==1){return 1;}


        return climb(steps-1) + climb(steps-2) + climb(steps-3);
    }

    public static int climbIter(int steps){
        int zero=1;
        int first=1;
        int second=2;


        int ways=0;
        for(int i=3;i<=steps;i++){
            ways = second + first + zero;
            zero=first;
            first=second;
            second=ways;
        }

        return ways;
    }

    public static void main(String[] args) {
        System.out.println(climb(4));
        System.out.println(climbIter(4));
    }
}
