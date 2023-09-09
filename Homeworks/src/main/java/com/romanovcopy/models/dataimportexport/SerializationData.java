package com.romanovcopy.models.dataimportexport;

import java.io.*;

public class SerializationData {

    public <T> void saveToFile(T data, String fileName) {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(data);
            System.out.println("Объект успешно сохранен в файл " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении объекта: " + e.getMessage());
        }
    }

    public <T> T readFromFile(String fileName) {
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            T object = (T) objectIn.readObject();
            System.out.println("Объект успешно считан из файла " + fileName);
            return object;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при считывании объекта: " + e.getMessage());
            return null;
        }
    }
}
