package com.chinawyny.enumdemo;

public interface Food {
    enum Coffee implements Food {
        BLACK_COFFEE,DECAF_COFFEE,LATTE,CAPPUCCINO
    }
    enum Dessert implements Food {
        FRUIT, CAKE, GELATO
    }

    public static void main(String[] args) {
        for (Food.Dessert dessert : Food.Dessert.values()) {
            System.out.print(dessert + " ");
        }
        System.out.println();

        Food food = Food.Dessert.CAKE;
        System.out.println(food);
    }
}
