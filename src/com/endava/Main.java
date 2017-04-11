package com.endava;

import com.endava.service.Menu;

public class Main {

    public static void main(String[] args) {

        Menu m = new Menu();
        try {
            m.mainMenu();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
