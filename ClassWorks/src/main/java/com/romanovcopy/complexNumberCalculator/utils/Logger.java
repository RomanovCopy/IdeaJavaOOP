package com.romanovcopy.complexNumberCalculator.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Клосс осуществляющий логирование операций путем их записи в файл с указанием даты и
 * времени.
 */
public class Logger {

    /**
     * путь к файлу логирования
     */
    private String filePath;

    public Logger(String filePath) {
        this.filePath = filePath;
    }

    /**
     * запись сообщения в файл с добавление текущей даты  и времени
     * @param message сообщение логирования от приложения
     */
    public void info(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
            writer.println(dateTime() + " *** " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Преобразует текущую дату и время в строчный формат
     * @return текущая дата и время
     */
    private String dateTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
}
