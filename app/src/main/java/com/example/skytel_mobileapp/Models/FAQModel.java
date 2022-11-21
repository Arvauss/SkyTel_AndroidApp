package com.example.skytel_mobileapp.Models;

public class FAQModel {
    private String id;
    private String Question;
    private String Answer;

    public FAQModel() {
    }

    public FAQModel(String id, String question, String answer) {
        this.id = id;
        Question = question;
        Answer = answer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }
}
