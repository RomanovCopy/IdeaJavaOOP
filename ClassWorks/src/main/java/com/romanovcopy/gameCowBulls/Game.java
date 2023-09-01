package com.romanovcopy.gameCowBulls;

public interface Game {

    void start(Integer sizeWord, Integer maxTry);
    Answer inputValue();
    GameStatus getGameStatus();
}
