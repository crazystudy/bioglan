package com.masterlee.entity;

public class Question {
    private String id;

    private String question;

    private String options;

    private String answer;

    private Double score;

    private Boolean includeImage;

    private Boolean type;

    private String secondQuestion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options == null ? null : options.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Boolean getIncludeImage() {
        return includeImage;
    }

    public void setIncludeImage(Boolean includeImage) {
        this.includeImage = includeImage;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getSecondQuestion() {
        return secondQuestion;
    }

    public void setSecondQuestion(String secondQuestion) {
        this.secondQuestion = secondQuestion == null ? null : secondQuestion.trim();
    }
}