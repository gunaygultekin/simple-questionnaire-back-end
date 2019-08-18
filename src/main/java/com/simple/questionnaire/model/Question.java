package com.simple.questionnaire.model;

import java.util.HashMap;

public class Question {
    private String q;
    private HashMap<String,Integer> answers;

    public Question(String q){
        this.q = q;
    }

    public void addAnswer(String answer, int point){
        if(answers == null){
            answers = new HashMap<>();
        }

        answers.put(answer,point);
    }

    public String getQ() {
        return this.q;
    }

    public HashMap<String, Integer> getAnswers() {
        return this.answers;
    }
}
