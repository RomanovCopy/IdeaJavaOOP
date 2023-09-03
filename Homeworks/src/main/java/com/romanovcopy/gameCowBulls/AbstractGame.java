package com.romanovcopy.gameCowBulls;

import com.romanovcopy.Main;

import java.io.*;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
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
        System.out.printf("Загадано слово состоящее из %d символов\n ",
                this.word.length());
        gameStatus = GameStatus.START;
        String log="New Game: "+word+" maxTry: "+maxTry;
        addLog(log);
    }

    @Override
    public Answer inputValue(String value) {
        int bulls = 0;
        int cows = 0;
        if(word.length()==value.length()){
            maxTry--;
            for (int i = 0; i < word.length(); i++) {
                if(word.contains(Character.toString(value.charAt(i)))&&word.charAt(i) == value.charAt(i)){
                    bulls++;
                } else if (word.contains(Character.toString(value.charAt(i)))&&word.charAt(i) != value.charAt(i)) {
                    cows++;
                }
            }
            if(word.length() == bulls ){
                gameStatus = GameStatus.WINNER;
            }
            if(maxTry == 0 && !gameStatus.equals(GameStatus.WINNER)){
                gameStatus = GameStatus.LOSE;
            }
        }else {
            value="Длины слов не совпадают.";
        }
        String log="User Input: "+value+" Buls: "+bulls+" Cows: "+cows+" MaxTry: "+maxTry;
        addLog(log);
        return new Answer(value,bulls,cows,maxTry);
    }

    @Override
    public GameStatus getGameStatus() {
        return gameStatus;
    }

    @Override
    public void setGameStatus(GameStatus status) {
        gameStatus=status;
    }

    @Override
    public boolean addLog(String log) {
            String date=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            log=date+"***"+log+"\n";
            String path= Main.getPathToLogs();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path,true))) {
                writer.write(log);
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл: " + e.getMessage());
                return false;
            }
            return true;
        }
}
