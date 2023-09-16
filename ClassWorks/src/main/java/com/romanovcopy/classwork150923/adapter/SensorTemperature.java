package com.romanovcopy.classwork150923.adapter;

// Интерфейс дополнительного датчика 
public interface SensorTemperature{
	public int identifier(); // идентификатор датчика
	public double temperature(); // температура датчика
	public int year();			 // Год
	public int day();			 // День года
	public int second();		 // Секунда дня
}
	