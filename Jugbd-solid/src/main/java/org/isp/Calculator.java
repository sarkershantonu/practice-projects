package org.isp;

/**
 * Created by shantonu on 3/12/16.
 */
public class Calculator implements Adder, Subtractor, Multiplyer, Dividor, Moder{

    public <T extends Number> Number add(T x, T y) {

        Double result = x.doubleValue()+y.doubleValue();

        return (Number) result;
    }

    public <T> T div(T x, T y) {
        return null;
    }

    public <T> T mod(T x, T y) {
        return null;
    }

    public <T> T mul(T x, T y) {
        return null;
    }

    public <T> T sub(T x, T y) {
        return null;
    }
}
