package com.namln;

public class ThreadThree extends Thread {
    private SharedData sharedData;

    public ThreadThree(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    public synchronized void run() {
        while (true) {
            synchronized (sharedData) {
                if (sharedData.getNumber() != null && sharedData.getNumber() % 2 != 0) {
                    System.out.println(">>> Thread 3 >>> " + sharedData.getNumber());
                    sharedData.setNumber(null);
                }
            }
        }
    }
}