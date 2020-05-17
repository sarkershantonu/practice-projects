package org.app;

/**
 * Created by SSarker on 6/12/2017.
 */
public class ReadMe {
    public String Title;
    public String Description;
    public String Input;
    public String Output;
    public String SampleInput;
    public String SampleOutput;
    public String RestOf;
    public ReadMe(){};
    public ReadMe(String title, String description, String input, String output, String sampleInput, String sampleOutput, String restOf) {
        Title = title;
        Description = description;
        Input = input;
        Output = output;
        SampleInput = sampleInput;
        SampleOutput = sampleOutput;
        RestOf = restOf;
    }

    @Override
    public String toString() {
        return  "# Title\n" + Title + '\n' +
                "# Description\n" + Description + '\n' +
                "# Input\n" + Input + '\n' +
                "# Output\n" + Output + '\n' +
                "# SampleInput\n" + SampleInput + '\n' +
                "# SampleOutput\n" + SampleOutput + '\n' +
                "# RestOf\n" + RestOf ;
    }
}
