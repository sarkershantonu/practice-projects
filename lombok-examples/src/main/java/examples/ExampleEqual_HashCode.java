package examples;

import lombok.EqualsAndHashCode;

/**
 * Created by shantonu on 5/31/16.
 */
@EqualsAndHashCode()
public class ExampleEqual_HashCode {
    private transient int transientVar = 10;
    private String name;
    private double score;
}
