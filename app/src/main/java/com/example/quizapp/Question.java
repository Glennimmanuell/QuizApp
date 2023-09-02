package com.example.quizapp;

public class Question {
    private int resId;
    private boolean answer;
    private boolean correctlyAnswered;

    public Question(int textId, boolean theanswer) {
        resId = textId;
        answer = theanswer;
        this.correctlyAnswered = false;
    }

    public int getResId() {
        return resId;
    }

    public boolean getAnswer() {
        return answer;
    }

    public boolean isCorrectlyAnswered() {
        return correctlyAnswered;
    }

    public void setCorrectlyAnswered(boolean correctlyAnswered) {
        this.correctlyAnswered = correctlyAnswered;
    }


}
