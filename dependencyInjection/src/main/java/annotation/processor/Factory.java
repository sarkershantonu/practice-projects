package annotation.processor;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Created by shantonu on 6/19/16.
 */
public class Factory {
    private static Map<Class<?>, Object> objects = new HashMap() ;
    public static Object getObject(Class<?> aClass){
        return objects.get(aClass);
    }
    public static void createInstance(Class<?> aClass)  {
        Object o = null;
        try {
            o = RefUtils.createInstance(aClass);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        objects.put(aClass,o);
    }
}
