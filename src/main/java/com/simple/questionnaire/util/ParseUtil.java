package com.simple.questionnaire.util;

import com.simple.questionnaire.model.Question;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class ParseUtil {

    public static Question parseQuestion(JSONObject questionObj){
        // get questionObj object
        JSONObject questionObject = (JSONObject) questionObj.get("question");

        // get questionObj
        String q = (String) questionObject.get("q");

        // Create a questionObj object
        Question question =  new Question(q);

        JSONArray answers = (JSONArray) questionObject.get("answers");

        answers.stream().forEach( item -> {
            JSONObject itemObj = (JSONObject) item;
            String answerObj = (String) itemObj.get("answer");
            int pointObj = Integer.parseInt((String) itemObj.get("points"));
            question.addAnswer(answerObj,pointObj);
            //System.out.println(answerObj);
            //System.out.println(pointObj);
        });

        return question;
    }
}
