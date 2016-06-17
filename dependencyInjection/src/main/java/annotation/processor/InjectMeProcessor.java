package annotation.processor;

import annotation.InjectMeHere;
import sun.reflect.annotation.AnnotationType;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by shantonu on 6/16/16.
 * todo => reflection base item invocation and processing
 */

public class InjectMeProcessor {

    public static void inject(Class<?> aClass)
    {
        String packageinfo = aClass.getPackage().getName();
        for(Field field : aClass.getDeclaredFields()) {
            field.setAccessible(true);
            String value = "I am assigning a value";
            System.out.println("Value to assign = "+value);
            if(field.isAnnotationPresent(InjectMeHere.class)){
                try {
                    field.set(null, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                    System.out.println("cant do");
                }
            }

        }
    }


}
