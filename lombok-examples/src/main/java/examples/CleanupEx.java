package examples;

import lombok.Cleanup;

import java.io.*;

/**
 * Created by shantonu on 5/18/16.
 */
public class CleanupEx {

    public void check() throws FileNotFoundException, IOException {
        @Cleanup
        FileInputStream fis = new FileInputStream("/Doc/Guide");
        @Cleanup
        FileOutputStream fos = new FileOutputStream("/Doc/Out");

    }

    public static void main(String[] args) throws IOException {
        String pom = System.getProperty("user.dir") + "/pom.xml";
        String io  = System.getProperty("user.dir") + "/logs/io.txt";
        @Cleanup InputStream in = new FileInputStream(pom);
        @Cleanup OutputStream out = new FileOutputStream(io);

        int reading;
        char c;

        while ((reading=in.read())!=-1){
            c=(char)reading;
            out.write(c);
        }
        out.flush();
    }
}
