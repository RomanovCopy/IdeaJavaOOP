package com.romanovcopy.gameCowBulls;

public interface Game {
    void start(Integer sizeWord, Integer maxTry);

    Answer inputValue(String value);

    GameStatus getGameStatus();
    void setGameStatus(GameStatus status);
    boolean addLog(String log);
}
