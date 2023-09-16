package com.romanovcopy.classwork150923.patterns.factory;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Point> pointList = new ArrayList<>(Arrays.asList(
                new Point(1, 5),
                new Point(1, 5),
                new Point(1, 5),
                new Point(4, 2)));
        Figure figure = FigureFactory.createFigure(pointList);
        System.out.println(figure.getClass().getName());
    }
}
