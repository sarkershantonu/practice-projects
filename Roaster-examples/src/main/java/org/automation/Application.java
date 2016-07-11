package org.automation;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.JavaClass;
import org.jboss.forge.roaster.model.source.JavaInterfaceSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Created by shantonu on 7/10/16.
 * target is to generate this => https://github.com/sarkershantonu/Unit-Testing-Examples/blob/master/Junit-Examples/src/test/java/parameterization/TestParameter.java
 */
public class Application {
    public static void main(String[] args) {
        createClass("TestWithParameter", "org.automation","org.junit.test");

    }
    public static void createClass(String name, String packageName, String... includes) {

        JavaClassSource javaClass = Roaster.create(JavaClassSource.class).
                setPackage(packageName).
                setName(name).
                setPublic();
        javaClass.addImport(includes[0]);
        javaClass.addAnnotation(RunWith.class).setClassValue(Parameterized.class);
        //javaClass.addTypeVariable("sks");
        javaClass = addGenericsTypeParameter(javaClass, String.class);
        System.out.println(javaClass);
        System.out.println(Application.class.getSimpleName());
    }

    public static JavaClassSource addIncludes(JavaClassSource source, String... args){

        for(String include : args) {
            source.addImport(include);
        }
        return source;
    }
    public static JavaClassSource addIncludes(JavaClassSource source, Class<?>... args){

        for(Class include : args) {
            source.addImport(include);
        }
        return source;
    }

    public static JavaClassSource addGenericsTypeParameter(JavaClassSource source, Class<?> aClass){
        source.addTypeVariable(aClass.getSimpleName());
        return source;
    }
}
