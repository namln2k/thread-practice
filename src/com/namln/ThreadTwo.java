package com.namln;

public class ThreadTwo extends Thread {
    private SharedData sharedData;

    public ThreadTwo(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    public synchronized void run() {
        while (true) {
            synchronized (sharedData) {
                if (sharedData.getNumber() != null && sharedData.getNumber() % 2 == 0) {
                    System.out.println(">>> Thread 2 >>> " + sharedData.getNumber());
                    sharedData.setNumber(null);
                }
            }
        }
    }
}