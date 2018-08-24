package basics.overflowunderflow;

public class OverflowUnderflow {


    public static void main(String[] args) {
        //this is Int MAX, so it will become negative
        int overflowExample = 2147483647;//expected outcome -2147483648
        System.out.println("Overflow: "+ (overflowExample + 1));

        //-2147483648 is one over int max, so reducing one it will bring back to positive max int
        int underflowExample = -2147483648;
        System.out.println("Underflow: "+ (underflowExample - 1));


        double d = 1e308;
        System.out.println(d + "*10= "+ d*10);

        //gradual underflow
        d = 1e-305*Math.PI;
        System.out.println("gradual underflow: "+d+"\n    ");
        for(int i=0; i< 4; i++){
            System.out.print(" "+(d/=100000));
        }

    }
}
