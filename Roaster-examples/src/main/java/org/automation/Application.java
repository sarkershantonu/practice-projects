package org.automation;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.JavaClass;
import org.jboss.forge.roaster.model.source.JavaInterfaceSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;
/**
 * Created by shantonu on 7/10/16.
 */
public class Application {
    public static void main(String[] args) {

    }
    public static void createClass(String name, String packageName, String[] includes) {

        JavaClassSource javaClass = Roaster.create(JavaClassSource.class).
                setPackage(packageName).
                setName(name).
                setPublic();

    }
}
