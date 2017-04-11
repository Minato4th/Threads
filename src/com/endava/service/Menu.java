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
        if (choice == Numbers.ONE.getNumber()){
            menuOne();
        } else if (choice == Numbers.TWO.getNumber()){
            menuTwo();
        } else if (choice == Numbers.THREE.getNumber()){
            menuThree();
        } else if (choice == Numbers.FOUR.getNumber()){
            menuFour();
        } else if (choice == Numbers.FIVE.getNumber()){
            menuFive();
        } else if (choice == Numbers.SIX.getNumber()){
            i = Numbers.SIX.getNumber();
        }

        if (choice > Numbers.SIX.getNumber()){
            Text.INCORRECT.getText();
            i++;
        } else if (choice < Numbers.SIX.getNumber()){
            i--;
        }

        return i;
    }


    private void menuOne() throws InterruptedException {
        System.out.println("Sum for current random array is " + methods.sum(arr));
    }

    private void menuTwo() throws InterruptedException {
        System.out.println("Max Value " + methods.maxValue(arr));
    }

    private void menuThree() throws InterruptedException {
        methods.reverseHelloMethod();
    }

    private void menuFour() throws InterruptedException {
        methods.accessPriority();
    }

    private void menuFive() throws InterruptedException {
        methods.lmbdaFunctionality();
    }

}
