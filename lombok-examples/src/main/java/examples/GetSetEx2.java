package examples;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import static lombok.Getter.*;

/**
 * Created by shantonu on 5/24/16.
 */
@Getter
@Setter(AccessLevel.PUBLIC)
public class GetSetEx2 {
    private String address;
    @Getter(AccessLevel.PRIVATE) private String name;
    private String id;
}
