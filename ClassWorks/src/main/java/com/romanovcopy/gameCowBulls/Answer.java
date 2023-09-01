package com.romanovcopy.gameCowBulls;

public class Answer {
    private String userInput;
    private Integer bull;
    private Integer cow;

    public String getUserInput() {
        return userInput;
    }

    public Integer getBull() {
        return bull;
    }

    public Integer getCow() {
        return cow;
    }

    public Answer(String userInput, Integer bull, Integer cow) {
        this.userInput = userInput;
        this.bull = bull;
        this.cow = cow;
    }
}
