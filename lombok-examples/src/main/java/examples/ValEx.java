package examples;

import lombok.val;

import java.util.Hashtable;

/**
 * Created by shantonu on 5/18/16.
 */
public class ValEx {
    public void  aMethod() {
        val store = new Hashtable<String, String>();

        store.put("one", new String("Shantonu"));

        val func = store.get("one");
        System.out.println(func.toLowerCase());

        store.put("two", "Andrii");
        store.put("three", "Oleks");

        for(val v: store.entrySet()){
            System.out.println("KEY =" +v.getKey()+", VAL = "+ v.getValue());
        }

    }
}
