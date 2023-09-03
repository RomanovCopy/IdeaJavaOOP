package com.romanovcopy;

import com.romanovcopy.gameCowBulls.*;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    private static String pathToLogs;
    private static String pathToRuGame;
    private static String pathToEnGame;

    /**
     * путь к файлу логов игры
     * @return абсолютный путь
     */
    public static String getPathToLogs() {return pathToLogs; }
    /**
     * путь к файлу словаря для RuGame
     * @return абсолютный путь
     */
    public static String getPathToRuGame() {return pathToRuGame;}
    /**
     * путь к файлу словаря для EnGame
     * @return абсолютный путь
     */
    public static String getPathToEnGame() {return pathToEnGame;}

    /**
     * флаг: разрешение на окончание игры
     */
    private static boolean exit;

    public static void main(String[] args) {
        //инициализация переменных
        String concate="\\src\\main\\java\\com\\romanovcopy\\gameCowBulls"+"\\logs.txt" ;
        pathToLogs = Paths.get(System.getProperty("user.dir"), concate).toString();
        concate="\\src\\main\\java\\com\\romanovcopy\\gameCowBulls"+"\\myDictionaries\\english.txt";
        pathToEnGame= Paths.get(System.getProperty("user.dir"), concate).toString();
        concate="\\src\\main\\java\\com\\romanovcopy\\gameCowBulls"+"\\myDictionaries\\russian.txt";
        pathToRuGame= Paths.get(System.getProperty("user.dir"), concate).toString();
        exit=false;

        //выбор режима игры
        Scanner scanner = new Scanner(System.in);
        Game game=(Game)selectMode(scanner);
        while (game==null&&!exit){
            game=(Game)selectMode(scanner);
        }
        //игра
        while (game!=null){
            int size = 0;
            int attempts=1;
            if(game instanceof GameNumber){
                System.out.println("Разрядность числа ? ");
                if(scanner.hasNextInt()){
                    size= scanner.nextInt();
                }
            }
            System.out.println("За сколько попыток справишься ? ");
            if(scanner.hasNextInt()){
                attempts = scanner.nextInt();
            }
            scanner.nextLine();
            game.start(size,attempts);
            while (!game.getGameStatus().equals(GameStatus.WINNER)
                    &&!game.getGameStatus().equals(GameStatus.LOSE)){
                System.out.print("Введи вариант слова : ");
                if(scanner.hasNextLine()){
                    String scannerWord = scanner.nextLine();
                    if(scannerWord.length()>0 && !scannerWord.equals("")){
                        Answer answer = game.inputValue(scannerWord);
                        System.out.printf("Введено %s \nBulls %d\nCows %d\nПопыток %d\n",
                                answer.getUserInput(),answer.getBull(),answer.getCow(),
                                answer.getMaxTry());
                    }else {
                        game.setGameStatus(GameStatus.LOSE);
                    }
                }
            }
            if(game.getGameStatus().equals(GameStatus.LOSE)){
                System.out.println("Ты проиграл!!!");
            }else if(game.getGameStatus().equals(GameStatus.WINNER)){
                System.out.println("Ты выиграл!!! Поздравляю!!!");
            }
            System.out.println("1 - играем еще;\n2 - надоело;\nКак поступим ?");
            if(scanner.hasNextInt()){
                int select= scanner.nextInt();
                if(select==2){
                    game=null;
                }else {
                    game=(Game)selectMode(scanner);
                    while (game==null&&!exit){
                        game=(Game)selectMode(scanner);
                    }
                }
            }
            scanner.nextLine();
        }
        scanner.close();
    }

    /**
     * Выбор режима игры
     * @param scanner поток ввода с консоли
     * @return выбранная игра
     */
    private static Game selectMode(Scanner scanner){
        System.out.println("Режимы игры : \n1 English words;\n2 Russian words;\n3 " +
                "Numbers;\n4 Просмотр истории игр;\n5 Очистить историю;");
        System.out.println("Выбери режим! \nДля выхода любая другая цифра");
        if(scanner.hasNextInt()){
            int mode= scanner.nextInt();
            if(mode==1){
                return new EnGame();
            } else if (mode==2) {
                return new RuGame();
            } else if (mode==3) {
                return new GameNumber();
            } else if (mode==4) {
                readingLogs();
                exit=false;
            } else if (mode==5) {
                clearLogs();
                exit=false;
            }else {
                System.out.println("Жаль, что ты испугался... :)\nУдачи!!!");
                exit=true;
            }
        }
        return null;
    }

    /**
     * чтение истории игр
     */
    private static void readingLogs(){
        File file = new File(pathToLogs);
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * очистка истории игр
     */
    private static void clearLogs(){
        try {
            FileWriter fileWriter = new FileWriter(pathToLogs);
            fileWriter.write("");
            fileWriter.close();
            System.out.println("Логи успешно очищены.");
        } catch (IOException e) {
            System.out.println("Ошибка при очистке файла: " + e.getMessage());
        }
    }


}

