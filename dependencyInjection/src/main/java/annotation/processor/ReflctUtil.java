package annotation.processor;

import java.lang.reflect.Field;

/**
 * Created by shantonu on 6/19/16.
 */
class ReflctUtil {
    private static Object getStaticField(final String aClass, final String aField) throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        Field field = Class.forName(aClass).getDeclaredField(aField);
        field.setAccessible(true);
        return field.get(Class.forName(aClass));
    }

    private static void setStaticField(final String aClass, final String aField, final Object value) throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        Field field = Class.forName(aClass).getDeclaredField(aField);
        field.setAccessible(true);
        Object old = field.get(Class.forName(aClass));
        field.set(old,value);
    }

    private static Object getField(final Object instance, final String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = instance.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(instance);
    }
    private static void setField(final Object instance, final String aField, final Object value) throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException {
        Field field = instance.getClass().getDeclaredField(aField);
        field.setAccessible(true);
        Object old = field.get(instance);
        field.set(old,value);
    }
}
