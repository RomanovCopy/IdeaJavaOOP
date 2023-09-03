package com.romanovcopy.gameCowBulls;

import com.romanovcopy.Main;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RuGame extends AbstractGame{

    @Override
    public String generateWord() {
        String path= Main.getPathToRuGame();
        String line=generateLine(path,500).replaceAll("[0-9\\s,.]", "").toLowerCase();
        return line;
    }
}
