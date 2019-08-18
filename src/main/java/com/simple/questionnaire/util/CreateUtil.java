package com.simple.questionnaire.util;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CreateUtil {

    private static final String dummyDataPath = "/resources/data.json";

    public static JSONArray createQuestion(){
        JSONArray questionList = null;

        //JSON parser object to read json file.
        JSONParser parser = new JSONParser();

        try {
            // create a file object and then file reader object
            File file = new File(new File("").getAbsolutePath() + "/src/main" + dummyDataPath);
            FileReader fileReader = new FileReader(file);

            //read json from file.
            questionList  = (JSONArray) parser.parse(fileReader);
            //System.out.println(questionList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return questionList;
    }
}
