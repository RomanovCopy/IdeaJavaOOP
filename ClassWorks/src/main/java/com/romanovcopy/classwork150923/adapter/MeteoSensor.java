package com.romanovcopy.classwork150923.adapter;

import java.time.*;

// Интерфейс родного датчика
public interface MeteoSensor {

    public int getId(); // идентификатор датчика

    public Float getTemperature(); // температура датчика

    public Float getHumidity(); // влажность

    public Float getPressure(); // давление

    public LocalDateTime getDateTime(); // время чтения данных датчика
}