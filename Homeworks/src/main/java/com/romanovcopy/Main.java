package com.romanovcopy;

import com.romanovcopy.gameCowBulls.Game;
import com.romanovcopy.gameCowBulls.GameNumber;
import com.romanovcopy.gameCowBulls.GameStatus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Game game=new GameNumber();
        game.start(5,5);
        Scanner scanner=new Scanner(System.in);
        while (!game.getGameStatus().equals(GameStatus.WINNER)&&
                !game.getGameStatus().equals(GameStatus.LOSE)){
            String scannerWord=scanner.nextLine();
            game.inputValue(scannerWord);
        }
        System.out.println(game.getGameStatus());

    }
}