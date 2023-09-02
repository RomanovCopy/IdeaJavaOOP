package com.romanovcopy.gameCowBulls;

import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RuGame extends AbstractGame{

    @Override
    public String generateWord() {
        String concate="\\src\\main\\java\\com\\romanovcopy\\gameCowBulls" +
                "\\myDictionaries\\russian.txt";
        String path= Paths.get(System.getProperty("user.dir"), concate).toString();
        String line=generateLine(path,500).replaceAll("[0-9\\s,.]", "").toLowerCase();
        return line;
    }
}
