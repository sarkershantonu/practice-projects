package annotation.processor;

import com.sun.deploy.util.JarUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * Created by shantonu on 6/19/16.
 * //todo , not used yet, but this will scan a jar to get neceary items
 */
public class JarUtils {
    JarUtil jarUtil = new JarUtil();

    public static List<Class<?>> getAllImplementation(Class<?> aClass) throws IOException, ClassNotFoundException {
        ArrayList<Class<?>> classes = new ArrayList<>();
            for(String itemInclassPath : System.getProperty("java.class.path").split(System.getProperty("path.separator"))){
                if(itemInclassPath.endsWith(".jar")){
                    //File jar = new File(itemInclassPath);
                    JarInputStream jarIs = new JarInputStream(new FileInputStream(new File(itemInclassPath)));
                    JarEntry entry;
                    while ((entry = jarIs.getNextJarEntry())!=null){
                        if(entry.getName().endsWith(".class")){
                            //checking with aClass
                            //todo implementation of class scanning & matching with
                            classes.add(Class.forName(entry.getName()));
                        }
                    }

                }
            }

        return classes;
    }


}
