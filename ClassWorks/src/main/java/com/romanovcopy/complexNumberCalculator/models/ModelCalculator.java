package com.romanovcopy.complexNumberCalculator.models;

import com.romanovcopy.complexNumberCalculator.calculator.ComplexNumberFactory;
import com.romanovcopy.complexNumberCalculator.interfaces.IComplexNumber;
import com.romanovcopy.complexNumberCalculator.interfaces.IModelCalculator;
import com.romanovcopy.complexNumberCalculator.views.ViewCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModelCalculator implements IModelCalculator {

    private ViewCalculator viewCalculator;

    private List<String>operations;

    private IComplexNumber firstNumber;
    private IComplexNumber secondNumber;
    private String operation;

    public ModelCalculator() {
        viewCalculator=new ViewCalculator();
        operations=new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
    }

    @Override
    public boolean setFirstNumber(){
        double real = viewCalculator.inputDouble("Введите действительную часть первого " +
                "числа");
        double imaginary = viewCalculator.inputDouble("Введите мнимую часть первого числа");
        firstNumber = ComplexNumberFactory.createComplexNumber(real, imaginary);
        return firstNumber!=null;
    }
    @Override
    public boolean setSecondNumber(){
        double real = viewCalculator.inputDouble("Введите действительную часть второго" +
                " " +
                "числа");
        double imaginary = viewCalculator.inputDouble("Введите мнимую часть второго " +
                "числа");
        secondNumber = ComplexNumberFactory.createComplexNumber(real, imaginary);
        return secondNumber!=null;
    }
    @Override
    public boolean setOperation(){
        operation=viewCalculator.inputString("Введите желаемую операцию ( +, -, *, / )");
        return operation.length()==1 && operations.contains(operation);
    }
    @Override
    public IComplexNumber operationExecute(){
        for(String operation:operations){
            if(this.operation.equals(operation)){
                return operationDeterminant(operation);
            }
        }
        return null;
    }
    @Override
    public void printResult(IComplexNumber complexNumber){
        StringBuilder builder=new StringBuilder("Результат вычисления : \n");
        builder.append(firstNumber.getReal()+" + "+firstNumber.getImaginary()+"I "+operation);
        builder.append(secondNumber.getReal()+" + "+ secondNumber.getImaginary()+"I = ");
        builder.append(complexNumber.getReal()+" + "+complexNumber.getImaginary()+"I\n");

        viewCalculator.message(builder.toString());
    }
    @Override
    public void printMessage(String message) {
        viewCalculator.message(message);
    }
    @Override
    public void printError(String errorMessage) {
        viewCalculator.errorMessage(errorMessage);
    }
    @Override
    public void close() {
        viewCalculator.close();
        System.exit(0);
    }


    /**
     * определение и выполнение операции
     * @param operation знак операции
     * @return результат выполнения операции или null в случае ошибки
     */
    private IComplexNumber operationDeterminant(String operation){
        switch (operation){
            case "+":{
                return firstNumber.add(secondNumber);
            }
            case "-":{
                return firstNumber.subtract(secondNumber);
            }
            case "*":{
                return firstNumber.multiply(secondNumber);
            }
            case "/":{
                return firstNumber.divide(secondNumber);
            }
            default:return null;
        }
    }

}
