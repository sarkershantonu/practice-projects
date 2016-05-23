package org.isp;

/**
 * Created by shantonu on 3/12/16.
 */
public interface Adder {
    <T extends Number> Number add(T x, T y);
}
