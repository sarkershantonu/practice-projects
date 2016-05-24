package examples;

import lombok.ToString;

/**
 * Created by shantonu on 5/24/16.
 */
@ToString(includeFieldNames = true)
public class ToStringEx {
    private String id;
    private String name;
}

@ToString(callSuper = false, doNotUseGetters = true)
class ToStringEx1 {
    private String name;
    private String id;
}

@ToString(of = "id")
class ToStringEx2 {
    private String name;
    private String id;

}

@ToString(exclude = {"name", "id"})
class ToStringEx3 {
    private String name;
    private String id;
}
