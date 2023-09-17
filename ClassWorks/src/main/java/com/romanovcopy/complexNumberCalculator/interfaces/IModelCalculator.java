package com.romanovcopy.complexNumberCalculator.interfaces;

public interface IModelCalculator {

    /**
     * генерация первого комплексного числа
     * @return реультат запроса: true - успешно; false - ошибка.
     */
    public boolean setFirstNumber();
    /**
     * генерация второго комплексного числа
     * @return реультат запроса: true - успешно; false - ошибка.
     */
    public boolean setSecondNumber();
    /**
     * получение и валидация знака операции
     * @return реультат запроса: true - успешно; false - ошибка.
     */
    public boolean setOperation();
    /**
     * выполнение операции
     * @return результат выполнения операции или null в случае ошибки
     */
    public IComplexNumber operationExecute();
    /**
     * вывод результата выполнения операции в консоль
     * @param complexNumber результат выполненной операции
     */
    public void printResult(IComplexNumber complexNumber);


}
