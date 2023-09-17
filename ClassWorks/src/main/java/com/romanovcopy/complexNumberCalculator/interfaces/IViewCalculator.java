package com.romanovcopy.complexNumberCalculator.interfaces;

public interface IViewCalculator {
    /**
     * прием ввода строки от пользователя
     * @param message сообщение пользователю
     * @return сообщение пользователя
     */
    public String inputString(String message);
    /**
     * прием ввода числа от пользователя
     * @param message сообщение пользователю
     * @return число пользователя
     */
    public Double inputDouble(String message);
    /**
     * сообщение пользователю без ввода
     * @param message сообщение
     */
    public void message(String message);
    /**
     * сообщение пользователю об ошибке без ввода
     * @param errorMessge сообщение об ошибке
     */
    public void errorMessage(String errorMessge);
}
