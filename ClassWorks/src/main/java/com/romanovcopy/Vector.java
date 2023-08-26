package com.romanovcopy;

public class Vector {

    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector() {
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    /**
     * @return длинна вектора
     * @apiNote метод, вычисляющий длину вектора.
     */
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * @param vector2 вектор с которым происходит умножениее
     * @return скалярное произведение
     * @apiNote метод, вычисляющий скалярное произведение
     */
    public double scal(Vector vector) {
        return x * vector.x + y * vector.y + z * vector.z;
    }

    /**
     *
     * @param vector Принимает в качестве параметра вектор на который делается векторное произведение.
     * @return Новый вектор как векторное произведение
     */
    public Vector vprod(Vector vector) {
        return new Vector(
                y * vector.z - z * vector.y,
                z * vector.x - x * vector.z,
                x * vector.y - y * vector.x);
    }

    /**
     * @return длинна вектора
     * @apiNote метод, вычисляющий длину вектора.
     */
    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    /**
     * Метод вычисляющий угол между векторами
     * @param vector1 Принимается в качестве значения
     * @return Скалярное произведение
     */
    public double angle(Vector vector1) {
        double v = length() * vector1.length();
        return scal(vector1)/ v;
    }

}
