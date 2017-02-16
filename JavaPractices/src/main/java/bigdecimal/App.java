package bigdecimal;

import java.math.BigDecimal;

/**
 * Created by shantonu on 2/14/17.
 */
public class App {
    public static void main(String[] args) {

        BigDecimal num1 = new BigDecimal(1234567);
        BigDecimal num2 = new BigDecimal(100000);

        System.out.println("No Rounding : "+num1.divide(num2));
        System.out.println("ROUND_CEILING @1 : "+num1.divide(num2, 1, BigDecimal.ROUND_CEILING));
        System.out.println("ROUND_FLOOR @1 : "+num1.divide(num2, 1, BigDecimal.ROUND_FLOOR));
        System.out.println("ROUND_DOWN @1 : "+num1.divide(num2, 1, BigDecimal.ROUND_DOWN));
        System.out.println("ROUND_HALF_DOWN @1 : "+num1.divide(num2, 1, BigDecimal.ROUND_HALF_DOWN));

        System.out.println("ROUND_CEILING @2 : "+num1.divide(num2, 2, BigDecimal.ROUND_CEILING));
        System.out.println("ROUND_FLOOR @2 : "+num1.divide(num2, 2, BigDecimal.ROUND_FLOOR));
        System.out.println("ROUND_DOWN @2 : "+num1.divide(num2, 2, BigDecimal.ROUND_DOWN));
        System.out.println("ROUND_HALF_DOWN @2 : "+num1.divide(num2, 2, BigDecimal.ROUND_HALF_DOWN));

        System.out.println("ROUND_CEILING @3 : "+num1.divide(num2, 3, BigDecimal.ROUND_CEILING));
        System.out.println("ROUND_FLOOR @3 : "+num1.divide(num2, 3, BigDecimal.ROUND_FLOOR));
        System.out.println("ROUND_DOWN @3 : "+num1.divide(num2, 3, BigDecimal.ROUND_DOWN));
        System.out.println("ROUND_HALF_DOWN @3 : "+num1.divide(num2, 3, BigDecimal.ROUND_HALF_DOWN));

        System.out.println("ROUND_CEILING @4 : "+num1.divide(num2, 4, BigDecimal.ROUND_CEILING));
        System.out.println("ROUND_FLOOR @4 : "+num1.divide(num2, 4, BigDecimal.ROUND_FLOOR));
        System.out.println("ROUND_DOWN @4 : "+num1.divide(num2, 4, BigDecimal.ROUND_DOWN));
        System.out.println("ROUND_HALF_DOWN @4 : "+num1.divide(num2, 4, BigDecimal.ROUND_HALF_DOWN));

        System.out.println("ROUND_CEILING @5 : "+num1.divide(num2, 5, BigDecimal.ROUND_CEILING));
        System.out.println("ROUND_FLOOR @5 : "+num1.divide(num2, 5, BigDecimal.ROUND_FLOOR));
        System.out.println("ROUND_DOWN @5 : "+num1.divide(num2, 5, BigDecimal.ROUND_DOWN));
        System.out.println("ROUND_HALF_DOWN @5 : "+num1.divide(num2, 5, BigDecimal.ROUND_HALF_DOWN));

    }
}
