package com.romanovcopy.fruitsEnum;

public class MyFruits {

    public MyFruits() {
        public static void main() {
            Fruit fruit = Fruit.APPLE;

            switch (fruit) {
                case APPLE:
                    System.out.println("Это яблоко");
                    break;
                case BANANA:
                    System.out.println("Это банан");
                    break;
                case ORANGE:
                    System.out.println("Это апельсин");
                    break;
                default:
                    System.out.println("Неизвестный фрукт");
            }
        }
    }
}
