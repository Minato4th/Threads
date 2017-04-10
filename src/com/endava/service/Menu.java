package com.endava.service;

import com.endava.util.Validator;

public class Menu {

    private Validator validator;
    private int choice;

    public Menu() {
        this.validator = new Validator();
        this.choice = 0;
    }

    public void mainMenu(){
        for (int i = 0; i < 3; i++) {
            Text.BASE.getText();
            choice = validator.isDigit();
            i = menuChoice(choice, i);
        }

        Text.BYE.getText();
    }

    private int menuChoice(int choice, int i){
        if (choice == Numbers.ONE.getNumber()){
            menuOne();
        } else if (choice == Numbers.TWO.getNumber()){
            menuTwo();
        } else if (choice == Numbers.THREE.getNumber()){
            menuThree();
        } else if (choice > Numbers.FOUR.getNumber()){
            menuFour();
        } else if (choice > Numbers.FIVE.getNumber()){
            menuFive();
        } else if (choice > Numbers.SIX.getNumber()){
            Text.INCORRECT.getText();
        }

        if (choice == Numbers.SIX.getNumber()){
            i = Numbers.SIX.getNumber();
        } else if (choice < Numbers.SIX.getNumber()){
            i--;
        }

        return i;
    }


    private void menuOne(){


    }

    private void menuTwo(){

    }

    private void menuThree(){

    }

    private void menuFour(){

    }

    private void menuFive(){

    }

}
