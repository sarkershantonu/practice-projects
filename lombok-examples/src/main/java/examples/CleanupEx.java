package examples;

import lombok.Cleanup;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by shantonu on 5/18/16.
 */
public class CleanupEx {

    public void check() throws FileNotFoundException , IOException {
        @Cleanup
        FileInputStream fis = new FileInputStream("/Doc/Guide");
        @Cleanup
        FileOutputStream fos = new FileOutputStream("/Doc/Out");

    }
}
