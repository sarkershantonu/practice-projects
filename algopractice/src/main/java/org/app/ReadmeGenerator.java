package org.app;

import java.io.*;

/**
 * Created by SSarker on 6/12/2017.
 * this will create readme file in given location
 */
public class ReadmeGenerator {
    public ReadMe aReadMe;
    public String path;

    public ReadmeGenerator(ReadMe aReadMe, String path) {
        this.aReadMe = aReadMe;
        this.path = path;
    }

    private ReadmeGenerator(){}
    public void create(){
        File fileName_path = new File(path+"/README.md");
        //File fileName_path = new File(path+"/README.md");
        System.out.println("PATH "+fileName_path.getAbsolutePath());
        try (FileWriter fw = new FileWriter(fileName_path.getAbsolutePath())) {
            fw.write(aReadMe.toString());
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

       /* try(PrintWriter out = new PrintWriter(new FileOutputStream(fileName_path.getAbsolutePath()))){
            out.print(aReadMe.toString());
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/


    }
}
