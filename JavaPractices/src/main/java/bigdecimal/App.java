package bigdecimal;

import java.math.BigDecimal;

/**
 * Created by shantonu on 2/14/17.
 */
public class App {
    public static void main(String[] args) {

        BigDecimal num1 = new BigDecimal(123456789);
        BigDecimal num2 = new BigDecimal(10000000);

        System.out.println("No Rounding : "+num1.divide(num2));

        for(int i=1; i<=8;i++){
            System.out.println("ROUND_CEILING @"+i+" : "+num1.divide(num2, i, BigDecimal.ROUND_CEILING));
            System.out.println("ROUND_FLOOR  @"+i+" : "+num1.divide(num2,i, BigDecimal.ROUND_FLOOR));
            System.out.println("ROUND_DOWN  @"+i+" : "+num1.divide(num2, i, BigDecimal.ROUND_DOWN));
            System.out.println("ROUND_HALF_DOWN  @"+i+" : "+num1.divide(num2, i, BigDecimal.ROUND_HALF_DOWN));
            System.out.println("ROUND_HALF_EVEN  @"+i+" : "+num1.divide(num2, i, BigDecimal.ROUND_HALF_EVEN));
            System.out.println("ROUND_HALF_UP  @"+i+" : "+num1.divide(num2, i, BigDecimal.ROUND_HALF_UP));
            System.out.println("ROUND_UP  @"+i+" : "+num1.divide(num2, i, BigDecimal.ROUND_UP));
           // System.out.println("ROUND_UNNECESSARY  @"+i+" : "+num1.divide(num2, i, BigDecimal.ROUND_UNNECESSARY));
            System.out.println("COMPLETE for Selling "+i);
        }
        /**
         * output : for only 6th
         * No Rounding : 12.3456789
         ROUND_CEILING @1 : 12.4
         ROUND_FLOOR  @1 : 12.3
         ROUND_DOWN  @1 : 12.3
         ROUND_HALF_DOWN  @1 : 12.3
         ROUND_HALF_EVEN  @1 : 12.3
         ROUND_HALF_UP  @1 : 12.3
         ROUND_UP  @1 : 12.4
         COMPLETE for Selling 1
         ROUND_CEILING @2 : 12.35
         ROUND_FLOOR  @2 : 12.34
         ROUND_DOWN  @2 : 12.34
         ROUND_HALF_DOWN  @2 : 12.35
         ROUND_HALF_EVEN  @2 : 12.35
         ROUND_HALF_UP  @2 : 12.35
         ROUND_UP  @2 : 12.35
         COMPLETE for Selling 2
         ROUND_CEILING @3 : 12.346
         ROUND_FLOOR  @3 : 12.345
         ROUND_DOWN  @3 : 12.345
         ROUND_HALF_DOWN  @3 : 12.346
         ROUND_HALF_EVEN  @3 : 12.346
         ROUND_HALF_UP  @3 : 12.346
         ROUND_UP  @3 : 12.346
         COMPLETE for Selling 3
         ROUND_CEILING @4 : 12.3457
         ROUND_FLOOR  @4 : 12.3456
         ROUND_DOWN  @4 : 12.3456
         ROUND_HALF_DOWN  @4 : 12.3457
         ROUND_HALF_EVEN  @4 : 12.3457
         ROUND_HALF_UP  @4 : 12.3457
         ROUND_UP  @4 : 12.3457
         COMPLETE for Selling 4
         ROUND_CEILING @5 : 12.34568
         ROUND_FLOOR  @5 : 12.34567
         ROUND_DOWN  @5 : 12.34567
         ROUND_HALF_DOWN  @5 : 12.34568
         ROUND_HALF_EVEN  @5 : 12.34568
         ROUND_HALF_UP  @5 : 12.34568
         ROUND_UP  @5 : 12.34568
         COMPLETE for Selling 5
         ROUND_CEILING @6 : 12.345679
         ROUND_FLOOR  @6 : 12.345678
         ROUND_DOWN  @6 : 12.345678
         ROUND_HALF_DOWN  @6 : 12.345679
         ROUND_HALF_EVEN  @6 : 12.345679
         ROUND_HALF_UP  @6 : 12.345679
         ROUND_UP  @6 : 12.345679
         COMPLETE for Selling 6

         */
    }
}
