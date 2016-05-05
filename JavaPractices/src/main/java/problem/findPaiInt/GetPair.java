package problem.findPaiInt;

import java.util.Scanner;

/**
 * Created by shantonu on 4/12/16.
 */
public class GetPair {

    public static void main(String[] args)  {

        Scanner inp =new Scanner(System.in);
        try {
            while(true) {
                int a = inp.nextInt();
                int b = inp.nextInt();
                    System.out.println("X = " + (a + b));
                }
            }
            catch (Exception ex)
            {
               //this will be a very very long exception due to input chain events
            }finally {
                inp.close();
            }



    }
}
