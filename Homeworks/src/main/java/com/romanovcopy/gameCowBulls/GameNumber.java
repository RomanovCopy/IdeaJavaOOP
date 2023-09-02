package com.romanovcopy.gameCowBulls;

import java.util.ArrayList;
import java.util.List;

public class GameNumber implements AbstractGame{

    @Override
    public String generateWord() {
        return super.generateWord();
    }

    @Override
    List<String> generateCharList() {
        List<String>list=new ArrayList<>(){'0','1','2','3','4','5','6','7','8','9'};
        return null;
    }

    @Override
    public void start(Integer sizeWord, Integer maxTry) {
        super.start(sizeWord, maxTry);
    }

    @Override
    public Answer inputValue(String value) {
        return super.inputValue(value);
    }

    @Override
    public GameStatus getGameStatus() {
        return super.getGameStatus();
    }
}
