package com.example.looperdemo;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class ThreadB implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.d(MainActivity.TAG, MainActivity.TAG);
            Message message = Message.obtain();
            message.what = 1;
            message.obj = System.currentTimeMillis();
            ThreadA.mHandler.sendMessage(message);
        }
    }
}
