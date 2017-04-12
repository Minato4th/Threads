package com.endava.service;

import com.endava.util.MenuMethods;
import com.endava.util.Validator;

public class Menu {

    private Validator validator;
    private int choice;
    private MenuMethods methods;
    int[] arr;

    public Menu() {
        validator = new Validator();
        choice = 0;
        methods = new MenuMethods();
        arr = methods.randomGenerator();
    }

    public void mainMenu() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Text.BASE.getText();
            choice = validator.isDigit();
            i = menuChoice(choice, i);
        }

        Text.BYE.getText();
    }

    private int menuChoice(int choice, int i) throws InterruptedException {
        if (choice == Numbers.ONE.getNumber()) {
            System.out.println("Sum for current random array is " + methods.sum(arr));
        } else if (choice == Numbers.TWO.getNumber()) {
            System.out.println("Max Value " + methods.maxValue(arr));
        } else if (choice == Numbers.THREE.getNumber()) {
            methods.reverseHelloMethod();
        } else if (choice == Numbers.FOUR.getNumber()) {
            methods.accessPriority();
        } else if (choice == Numbers.FIVE.getNumber()) {
            methods.lmbdaFunctionality();
        } else if (choice == Numbers.SIX.getNumber()) {
            i = Numbers.SIX.getNumber();
        }

        if (choice > Numbers.SIX.getNumber()) {
            Text.INCORRECT.getText();
            i++;
        } else if (choice < Numbers.SIX.getNumber()) {
            i--;
        }

        System.out.println();

        return i;
    }
}
