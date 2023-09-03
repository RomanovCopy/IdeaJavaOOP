package com.romanovcopy.gameCowBulls;

public interface Game {
    void start(Integer sizeWord, Integer maxTry);

    Answer inputValue(String value);

    GameStatus getGameStatus();
    void setGameStatus(GameStatus status);
    /**
     * запись лога в файл
     * @param log текст лога
     * @return результат записи: true - удачно; false - ошибка.
     */
    boolean addLog(String log);
}
