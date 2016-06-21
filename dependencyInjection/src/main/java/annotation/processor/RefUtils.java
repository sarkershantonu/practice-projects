package annotation.processor;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shantonu on 6/19/16.
 */
public class RefUtils {
    public static Object getStaticField(final String aClass, final String aField) throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        Field field = Class.forName(aClass).getDeclaredField(aField);
        field.setAccessible(true);
        return field.get(Class.forName(aClass));
    }

    public static void setStaticField(final String aClass, final String aField, final Object value) throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        Field field = Class.forName(aClass).getDeclaredField(aField);
        field.setAccessible(true);
        Object old = field.get(Class.forName(aClass));
        field.set(old, value);
    }


    public static Object getField(final Object instance, final String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = instance.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(instance);
    }

    public static void setField(final Object instance, final String aField, final Object value) throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        Field field = instance.getClass().getDeclaredField(aField);
        field.setAccessible(true);
        field.set(instance, value);
    }

    public static Object createInstance(final Class<?> aClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return aClass.getConstructor().newInstance();
    }

    /**
     * This will returns all of the classes implemented form the interface/class/abstract class
     * @param aClass
     * @return
     * TODO using reflection
     */
    public static List<Class<?>> getSubTypesOf(Class<?> aClass){
        List<Class<?>> classes = new ArrayList<>();
        String classPath = System.getProperty("java.class.path");
        String javaHome = System.getProperty("java.home");
        String[] paths = classPath.split(File.separator);
// todo , 1 , get all paths from maven target, and
        return classes;
    }

    public static List<Class<?>> getSuperTypesOf(Class<?> aClass){
        List<Class<?>> classes = new ArrayList<>();
        classes.add(aClass.getSuperclass());
        for(Class<?> k: aClass.getInterfaces()){// gettint interfaces
            classes.add(k);
        }

        return classes;
    }
}
