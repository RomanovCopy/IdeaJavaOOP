package com.romanovcopy.classwork150923.decoratorFactory;

public class LogCalculator implements Calculable {

    private Calculable decorated;
    private Logable logable;

    public LogCalculator(Calculable decorated, Logable logable) {
        this.decorated = decorated;
        this.logable = logable;
    }

    @Override
    public Calculable sum(int arg) {
        logable.log("вызвался метод суммы с параметром : " + arg);
        return decorated.sum(arg);
    }

    @Override
    public Calculable multi(int arg) {
        logable.log("вызвался метод умножения с параметром : " + arg);
        return decorated.multi(arg);
    }

    @Override
    public int getResult() {
        logable.log("пользователь запросил результат!");
        return decorated.getResult();
    }
}
