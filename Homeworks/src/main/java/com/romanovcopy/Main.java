package com.romanovcopy;

import com.romanovcopy.gameCowBulls.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game=(Game)selectMode(scanner);
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
                "Numbers; ");
        System.out.println("Выбери режим! \nДля выхода любая другая цифра");
        if(scanner.hasNextInt()){
            int mode= scanner.nextInt();
            if(mode==1){
                return new EnGame();
            } else if (mode==2) {
                return new RuGame();
            } else if (mode==3) {
                return new GameNumber();
            }else {
                System.out.println("Жаль, что ты испугался... :)\nУдачи!!!");
            }
        }
        return null;
    }


}

