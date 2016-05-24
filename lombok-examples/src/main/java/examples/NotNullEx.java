package examples;

import lombok.NonNull;

/**
 * Created by shantonu on 5/24/16.
 */


public class NotNullEx {
    private  String name;
    private String id;
    private String address;

    public NotNullEx(String id){
        //this throws null pointer exception if id is null
    }

    public @NonNull String doSomeWork(){

        return null;
    }
}
