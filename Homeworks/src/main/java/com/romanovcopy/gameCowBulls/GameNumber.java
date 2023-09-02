package com.romanovcopy.gameCowBulls;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GameNumber extends AbstractGame{

    @Override
    String generateWord() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < sizeWord; i++) {
            int randomNumber = random.nextInt(10);
            sb.append(randomNumber);
        }
        return sb.toString();
    }
}
