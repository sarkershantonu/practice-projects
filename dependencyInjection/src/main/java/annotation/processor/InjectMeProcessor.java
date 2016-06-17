package annotation.processor;

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
            for (Annotation type : field.getDeclaredAnnotations())
            {
                
            }
        }
    }
}
