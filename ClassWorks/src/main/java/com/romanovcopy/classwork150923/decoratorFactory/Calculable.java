package com.romanovcopy.classwork150923.decoratorFactory;

public interface Calculable {
    Calculable sum(int arg);
    Calculable multi(int arg);
    int getResult();
}
