package com.romanovcopy.gameCowBulls;


public class Answer {
    private String userInput;
    private Integer bull;
    private Integer cow;


    private Integer maxTry;

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public void setBull(Integer bull) {
        this.bull = bull;
    }

    public void setCow(Integer cow) {
        this.cow = cow;
    }

    public String getUserInput() {
        return userInput;
    }

    public Integer getBull() {
        return bull;
    }

    public Integer getCow() {
        return cow;
    }

    public Integer getMaxTry() { return maxTry; }

    @Override
    public String toString() {
        return "Answer{" +
                "userInput='" + userInput + '\'' +
                ", bull=" + bull +
                ", cow=" + cow +
                ",maxTry"+ maxTry +
                '}';
    }

    public Answer(String userInput, Integer bull, Integer cow, Integer maxTry) {
        this.userInput = userInput;
        this.bull = bull;
        this.cow = cow;
        this.maxTry=maxTry;
    }
}
