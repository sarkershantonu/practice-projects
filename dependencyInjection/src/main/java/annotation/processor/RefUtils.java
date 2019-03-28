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

    public static List<Class<?>> getSuperTypesOf(Class<?> aClass){
        List<Class<?>> classes = new ArrayList<>();
        classes.add(aClass.getSuperclass());
        for(Class<?> k: aClass.getInterfaces()){// gettint interfaces
            classes.add(k);
        }

        return classes;
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
        String[] paths = classPath.split(seperator());
        // todo , 1 , get all paths from maven target, and
        File file = new File(javaHome+seperator()+"lib");// non maven deployent
        if(file.exists()){

        }
        return classes;
    }

    //todo
   private static List<String> getClasses(File rootFolder, File file,Class<?> aClass, boolean isWithJar){
       List<String> found = new ArrayList<>();
       if(file.isDirectory()){
           for(File aFile: file.listFiles()){
               getClasses(rootFolder,aFile,aClass,isWithJar);//this is check for folders , calling it self
           }
       }
       else{

       }

       return found;
   }

    private static String getClassNameFrom(File root, File file){
        StringBuilder stringBuilder=new StringBuilder();

        String filename = file.getName();

        stringBuilder.append(filename.substring(0,filename.lastIndexOf(".class")));
        file= file.getParentFile();//get the folder name, or null for toppest
        while (file!=null&& !file.equals(root)){
            stringBuilder.insert(0,'.').insert(0,file.getName());
            file=file.getParentFile();
        }

        return stringBuilder.toString();
    }
    private static String seperator(){
        return System.getProperty("path.separator");
    }

}
