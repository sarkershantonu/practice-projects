package annotation.processor;

import annotation.InjectMeHere;
import products.FileService;
import products.Service;
import products.XMLService;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by shantonu on 6/16/16.
 * todo => reflection base item invocation and processing
 */

public class InjectMeProcessor {

    public static void inject(Class<?> aClass) {
        Object o = Factory.getObject(aClass);
        String packageinfo = aClass.getPackage().getName();
        String className = aClass.getName();
        for (Field field : aClass.getDeclaredFields()) {
            field.setAccessible(true);
            String value = "Shantonu Example : ";
            System.out.println("field = " + field.getName());

            if (field.isAnnotationPresent(InjectMeHere.class)) {
                if (field.getType().isAssignableFrom(String.class)) {// it is better to use assignable to string rather direct equal
                    if (Modifier.isStatic(field.getModifiers())) {
                        try {
                            value += " Static injection....  " + field.getType().getName();
                            //refactored from field.set(null, value);
                            RefUtils.setStaticField(className, field.getName(), value);

                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                            System.out.println("cant do");
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        try {

                           //refactored from  field.set(old, "lol");
                            RefUtils.setField(o,field.getName(),"lol");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }else if (field.getType().isAssignableFrom(Service.class)){//this is todo, supporting the interface we need to implement
                    if (Modifier.isStatic(field.getModifiers())) {
                        try {

                            RefUtils.setStaticField(className, field.getName(), Factory.getObject(XMLService.class));//todo , using reflection to get service interface implements.
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        }

                    }else{
                        try {
                            RefUtils.setField(o,field.getName(), Factory.getObject(FileService.class));// same todo
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (NoSuchFieldException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            field.setAccessible(false);
        }
    }

    private static void assign(){}

    public static void run(Class<?> aClass) {
        inject(aClass);

    }

}
