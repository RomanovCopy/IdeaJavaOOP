package com.romanovcopy.gameCowBulls;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EnGame extends AbstractGame{

    @Override
    public String generateWord() {
        String concate="\\src\\main\\java\\com\\romanovcopy\\gameCowBulls" +
                "\\myDictionaries\\english.txt";
        String path= Paths.get(System.getProperty("user.dir"), concate).toString();
        String line=generateLine(path,500).replaceAll("[0-9\\s,.]", "").toLowerCase();
        return line;
    }

}
