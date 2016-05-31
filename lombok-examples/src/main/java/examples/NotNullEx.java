package examples;

import lombok.NonNull;

/**
 * Created by shantonu on 5/24/16.
 */


public class NotNullEx {
    private  String name;
    private String id;
    private String address;

    public NotNullEx( @NonNull String id){
        //this throws null pointer exception if id is null
        this.id=id;
    }
    public static void main(String... args){
        new NotNullEx(null);
    }
}
