package com.romanovcopy.gameCowBulls;

import com.romanovcopy.Main;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EnGame extends AbstractGame{

    @Override
    public String generateWord() {
        String path = Main.getPathToEnGame();
        String line=generateLine(path,500).replaceAll("[0-9\\s,.]", "").toLowerCase();
        return line;
    }

}
