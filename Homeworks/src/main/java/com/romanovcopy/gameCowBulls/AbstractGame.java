package com.romanovcopy.gameCowBulls;

import java.util.List;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class AbstractGame implements Game{

    Integer sizeWord;
    Integer maxTry;
    String word;
    GameStatus gameStatus = GameStatus.INIT;


    /**
     * метод предзаполняет слова компьютера
     * @return
     */
    abstract String generateWord();


    /**
     * считывание случайной строки из файла
     * @param filePath абсолютный путь к файлу
     * @param lineCount количество строк в файле
     * @return случайная строка
     */
    protected String generateLine(String filePath, int lineCount){
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            if (lineCount > 0) {
                Random random = new Random();
                int randomLineIndex = random.nextInt(lineCount) + 1;

                // Сбрасываем сканнер и пропускаем строки до случайной строки
                scanner = new Scanner(file);
                for (int i = 1; i < randomLineIndex; i++) {
                    scanner.nextLine();
                }
                // Считываем случайную строку
                String randomLine = scanner.nextLine();
                return randomLine;
            } else {
                System.out.println("Извини. Я забыл слова...");
            }
            scanner.close();
            return null;
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка считывания: " + e.getMessage());
            return null;
        }
    }


    @Override
    public void start(Integer sizeWord, Integer maxTry) {

        this.sizeWord = sizeWord;
        this.maxTry = maxTry;
        this.word = generateWord();
        gameStatus = GameStatus.START;
    }

    @Override
    public Answer inputValue(String value) {
        maxTry--;
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == value.charAt(i)){
                bulls++;
                cows++;
            } else{
                for (int j = 0; j < word.length(); j++) {
                    if(word.charAt(j) == value.charAt(i)){
                        cows++;
                    }
                }
            }
        }
        if(word.length() == bulls ){
            gameStatus = GameStatus.WINNER;
        }
        if(maxTry == 0 && !gameStatus.equals(GameStatus.WINNER)){
            gameStatus = GameStatus.LOSE;
        }
        return new Answer(value,bulls,cows,maxTry);
    }

    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }
}
