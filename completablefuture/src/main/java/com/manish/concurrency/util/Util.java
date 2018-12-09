package com.manish.concurrency.util;

/**
 * Created by manishpeshwani on 09-12-2018.
 */
public class Util {

    public static void sleep(long milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
