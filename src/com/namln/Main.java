package com.namln;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        SharedData sharedData = new SharedData();

        Thread t1 = new ThreadOne(sharedData);
        Thread t2 = new ThreadTwo(sharedData);
        Thread t3 = new ThreadThree(sharedData);
        t1.start();
        t2.start();
        t3.start();
    }
}
