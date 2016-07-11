package org.automation;

import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.JavaClass;
import org.jboss.forge.roaster.model.source.JavaInterfaceSource;
import org.jboss.forge.roaster.model.source.JavaClassSource;
import org.jboss.forge.roaster.model.util.Strings;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        //javaClass = addGenericsTypeParameter(javaClass, String.class);
        //javaClass.addTypeVariable("T").setBounds(Object.class, Integer.class);
        //javaClass = addGenericsTypeParameter(javaClass, "T",String.class);

        javaClass.addMethod().setPublic().setReturnTypeVoid().setName("TestD").setParameters("String ddd, String ppp");

        javaClass = addPublicVoidMethod(javaClass, "TestDdd",
                new String [][] {new String[]{"String", "Sasadasd"},new String[]{"Integer", "5"}});
        System.out.println(javaClass);

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

    public static JavaClassSource addPublicVoidMethod(JavaClassSource source, String methodName, final String[][] typeAndVerNames){
        StringBuilder arguments = new StringBuilder();
        int max = typeAndVerNames.length;
        for(int i=0; i<max;i++){
            arguments.append(typeAndVerNames[i][0]+" "+typeAndVerNames[i][1]);
            if(i<max-1){
                arguments.append(",");
            }

        }

        source.addMethod().setPublic().setReturnTypeVoid().setName(methodName).setParameters(arguments.toString());

        return source;
    }
    public static JavaClassSource addGenericsTypeParameter(JavaClassSource source, Class<?> aClass){
        source.addTypeVariable(aClass.getSimpleName());
        return source;
    }
    public static JavaClassSource addGenericsTypeParameter(JavaClassSource source,String T,  Class<?> aClass){
        source.addTypeVariable(T).setBounds(aClass.getSimpleName());
        return source;
    }
}
