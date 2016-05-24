package examples;

import lombok.Cleanup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by shantonu on 5/18/16.
 */
public class CleanupEx {

    public void check() throws FileNotFoundException {
        @Cleanup
        FileInputStream fis = new FileInputStream("/Doc/Guide");
        @Cleanup
        FileOutputStream fos = new FileOutputStream("/Doc/Out");

    }
}
