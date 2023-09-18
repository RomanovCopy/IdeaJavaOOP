package com.romanovcopy.complexNumberCalculator.interfaces;

public interface IComplexNumber {

    /**
     * получение действительной части числа
     * @return действительная часть числа
     */
    double getReal();
    /**
     * получение мнимой части числа
     * @return мнимая часть числа
     */
    double getImaginary();

    /**
     * сумма текущего числа с другим
     * @param other другое комплексное число
     * @return результат выполнения операции
     */
    IComplexNumber add(IComplexNumber other);
    /**
     * разность текущего числа с другим
     * @param other другое комплексное число
     * @return результат выполнения операции
     */
    IComplexNumber subtract(IComplexNumber other);
    /**
     * произведение текущего числа с другим
     * @param other другое комплексное число
     * @return результат выполнения операции
     */
    IComplexNumber multiply(IComplexNumber other);
    /**
     * частное текущего числа с другим
     * @param other другое комплексное число
     * @return результат выполнения операции
     */
    IComplexNumber divide(IComplexNumber other);

    /**
     * получение строчного представления числа
     * @return строчное представление числа
     */
    String toString();
}
