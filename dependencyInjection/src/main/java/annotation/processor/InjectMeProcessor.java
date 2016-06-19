package annotation.processor;

import annotation.InjectMeHere;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by shantonu on 6/16/16.
 * todo => reflection base item invocation and processing
 */

public class InjectMeProcessor {

    public static void inject(Class<?> aClass)
    {
        Object o = Factory.getObject(aClass);
        String packageinfo = aClass.getPackage().getName();
        for(Field field : aClass.getDeclaredFields()) {
            field.setAccessible(true);
            String value = "Shantonu Example : ";
            System.out.println("field = "+field.getName());
            if(field.isAnnotationPresent(InjectMeHere.class)) {
                if (Modifier.isStatic(field.getModifiers())) {
                    try {

                        value += " Static injection....  " + field.getType().getName();
                        //refactored from field.set(null, value);
                        RefUtils.setStaticField(aClass.getName(),field.getName(),value);

                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                        System.out.println("cant do");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    try {
                        Object old = o;
                        System.out.println(aClass.getName()+" OLD "+old.toString());
                        field.set(old,"lol");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            field.setAccessible(false);
        }
    }

    public static void inject(Class<?> aClass,Object obj){
        inject(aClass);

        for(Field field : obj.getClass().getDeclaredFields()){
            if (field.isAnnotationPresent(InjectMeHere.class)) {
                System.out.println("name => "+field.getName());
                try {
                    if(!Modifier.isStatic(field.getModifiers())){
                        System.out.println("Non static name => "+field.getName());
                        RefUtils.setField(obj,field.getName(),"SettingVAL");
                    }

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

    public static void run(Class<?> aClass){
        inject(aClass);

    }

}
