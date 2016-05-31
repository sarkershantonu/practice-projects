package examples;

import lombok.Builder;
import lombok.Singular;

import java.util.Set;

/**
 * Created by shantonu on 5/24/16.
 */
@Builder(builderClassName = "shantonu",
        buildMethodName = "make",
        builderMethodName = "creator",
        toBuilder = true)
public class Model {
    private String name;
    private String id;
    @Singular private Set<String> addresses;

}
