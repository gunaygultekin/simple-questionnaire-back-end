package com.simple.questionnaire.controller;

import com.simple.questionnaire.model.Question;
import com.simple.questionnaire.util.CreateUtil;
import com.simple.questionnaire.util.ParseUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ServerController {

    private List<Question> questionsAndAnswers;

    @RequestMapping(path = "/read/questions", method = GET)
    public ResponseEntity readQuestions(){
        JSONArray questionList = CreateUtil.createQuestion();

        questionsAndAnswers = new ArrayList<>();

        //Iterate over the json array list
        questionList.forEach(question -> {
            questionsAndAnswers.add(ParseUtil.parseQuestion( (JSONObject) question));
        });

        return new ResponseEntity<>(questionsAndAnswers, HttpStatus.OK);
    }

    @RequestMapping(path = "/read/question/{orderId}", method = GET)
    public ResponseEntity readQuestion(@PathVariable int orderId){
        JSONArray questionList = CreateUtil.createQuestion();
        if( orderId  > questionList.size() || orderId <= 0 )
            return new ResponseEntity<>("N/A", HttpStatus.NOT_FOUND);

        questionsAndAnswers = new ArrayList<>();

        //Iterate over the json array list
        int index = orderId - 1; // because the start index of array is 0;
        JSONObject question = (JSONObject)  questionList.get(index);
        questionsAndAnswers.add(ParseUtil.parseQuestion(question));

        return new ResponseEntity<>(questionsAndAnswers, HttpStatus.OK);
    }

    @RequestMapping(path = "/get/questions/size", method = GET)
    public int getQuestionSize(){
        return CreateUtil.createQuestion().size();
    }
}
