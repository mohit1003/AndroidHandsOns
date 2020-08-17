package com.example.citizenquiz;

public class Question {
    private int answerId;
    private boolean isTrue;

    public Question(int answerId, boolean isTrue) {
        this.answerId = answerId;
        this.isTrue = isTrue;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }
}
