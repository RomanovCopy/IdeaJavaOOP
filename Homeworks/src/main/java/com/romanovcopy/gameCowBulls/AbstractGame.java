package com.romanovcopy.gameCowBulls;

import java.util.List;
import java.util.Random;

public abstract class AbstractGame implements Game{

    /**
     * длина слова
     */
    Integer sizeWord;
    /**
     * допустимое количество попыток
     */
    Integer maxTry;
    /**
     * загаданное слово
     */
    String word;

    /**
     * текущий статус игры
     */
    GameStatus gameStatus=GameStatus.INIT;


    public String generateWord(){
        return null;
    }

    abstract List<String> generateCharList(){
        List<String>alphavit=generateCharList();
        Random r=new Random();
        String result="";
        for(int i=0;i<sizeWord;i++){
            int index=r.nextInt(alphavit.size());
            result=result.concat(alphavit.get(index));
            alphavit.remove(index);
        }
        return result;
    }

    @Override
    public void start(Integer sizeWord, Integer maxTry) {
        this.sizeWord=sizeWord;
        this.maxTry=maxTry;
        word=generateWord();
        gameStatus=GameStatus.START;

    }

    @Override
    public Answer inputValue(String value) {
        maxTry--;
        int bulls=0;
        int cows=0;
        for(int i;i<word.length();i++){
            if(word.charAt(i)==value.charAt(i)){
                bulls++;
                cows++;
            } else  {
                for(int j=0;j<word.length();j++){
                    if(word.charAt(j)==value.charAt(i)){
                        cows++;
                    }
                }
            }
        }
        if(word.length()==bulls){
            gameStatus=GameStatus.WINNER;
        }
        if(!maxTry==0 && gameStatus.equals(GameStatus.WINNER)){
            gameStatus=GameStatus.LOSE;
        }
        Answer answer=new Answer(value, bulls, cows);
        return answer;
    }

    @Override
    public GameStatus getGameStatus() {
        return null;
    }
}
