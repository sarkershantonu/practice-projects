package org.app;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SSarker on 6/9/2017.
 * this is crawler for devskills
 */
public class CrawlDevSkill {
    public static String url = "https://www.devskill.com/CodingProblems/ViewProblem/";





    public static void main(String[] args) throws IOException {
        CrawlDevSkill crawler = new CrawlDevSkill();
        ReadmeGenerator generator = new ReadmeGenerator(crawler.get(1),"./target");
        generator.create();


       /* Document doc = Jsoup.connect(url+1).get();
        System.out.println(doc.title());
        String name = doc.title().substring(12);
        System.out.println(name.replace(" ","_")+1+"Solution");*/
       /*
        for (int i = 1; i <= 351; i++) {
            Document doc = Jsoup.connect(url+1).get();
            System.out.println("ID = "+i+" Title"+doc.title());
            //if Coding Problem Archive then no need to generate
            //Dev Skill - Credit Shop should be Credit_Shop
        }*/
    }
    public String getSoultionCassName(Document doc){
        return doc.title().substring(12).replace(" ","_")+""+"_Solution.java";
    }
    public String getTitle(Document document) {
        return document.title();
    }
    private ReadMe get(int i) throws IOException {
        Document doc = Jsoup.connect(url+i).get();
        ReadMe readMe = new ReadMe();
        String title  = doc.title();
        Elements elements = doc.getAllElements();
        Elements getBodyCOntents = doc.select("#body-content");
        readMe.Title=doc.title();
        System.out.println(title);
        String className = doc.title().substring(12).replace(" ","_")+i+"_Solution.java";
        System.out.println(className);
        String testName="Test_"+className;
        System.out.println(testName);

        String description = doc.select(".mark-down-html").html();
        //System.out.println(description);

        String sample_input_regix="Sample\\sInput[\\s-]+(.+?)Sample\\sOutput";
        Matcher m = Pattern.compile(sample_input_regix).matcher(description);
        while(m.find()){
            System.out.println( m.group(1).replace(" ","\n"));
            readMe.SampleInput=m.group(1).replace(" ","\n\n");
        }

        String sample_output_regix="Sample\\sOutput[\\s-]+([\\w\\s]+)";
        m = Pattern.compile(sample_output_regix).matcher(description);
        while(m.find()){
            System.out.println( m.group(1).replace(" ","\n\n"));
            readMe.SampleOutput= m.group(1).replace(" ","\n\n");
        }

        readMe.Input=getInput(doc);
        readMe.Output=getOutput(doc);
        readMe.Description=getDescription(doc);
        return readMe;
    }
    public String getSampleInput(Document doc) {
        String description = doc.select(".mark-down-html").html();
        String input_regix="Input:[\\s-]+(.+?)Output";
        return getFirstGroupFrom(description,input_regix);
    }

    public void getSampleOutput(Document doc) {
    }

    public void getRestOf(Document doc) {
    }

    public String getFullBody(Document doc) {
        return doc.select(".mark-down-html").html();
    }

    public String getInput(Document doc) {
        String description = doc.select(".mark-down-html").html();
        String input_regix="Input:[\\s-]+(.+?)Output";
        return getFirstGroupFrom(description,input_regix);
    }
    private String getFirstGroupFrom(String source, String regix_pattern){
        Matcher m =  Pattern.compile(regix_pattern).matcher(source);
        String des="Description";
        while(m.find()){
            des = m.group(1);
        }
        return des;
    }
    public String getDescription(Document doc) {
        String description = doc.select(".mark-down-html").html();
        String description_regix="(.+?)Input:";
        return getFirstGroupFrom(description,description_regix);
    }

    public String getOutput(Document doc) {
        String description = doc.select(".mark-down-html").html();
        String input_regix="Output:[\\s-]+(.+?)Sample";
        return getFirstGroupFrom(description,input_regix);
    }




}
