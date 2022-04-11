package com.namln;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ThreadOne extends Thread {
    private File file;
    private Scanner sc;
    private SharedData sharedData;

    public ThreadOne(SharedData sharedData) throws FileNotFoundException {
        this.file = new File("src/com/namln/data.txt");
        this.sc = new Scanner(file);
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while(sc.hasNextLine()) {
            String temp = this.sc.nextLine();
            synchronized (this) {
                try {
                    Integer number = Integer.valueOf(temp);
                    sharedData.setNumber(number);
                }
                catch (NumberFormatException ex){
                    ex.printStackTrace();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
