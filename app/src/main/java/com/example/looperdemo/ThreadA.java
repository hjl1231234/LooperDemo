package com.example.looperdemo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

public class ThreadA implements Runnable {
    public static Handler mHandler;

    //run运行后才不为null在main里判断
    public Handler getHandler() {
        return mHandler;
    }
    ThreadLocal threadLocal;


    @Override
    public void run() {
        //不要会怎样?
        Looper.prepare();
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                            Toast.makeText(MyApplication.getContext(), "线程B发过来消息了" + msg.obj, Toast.LENGTH_SHORT).show();

                        break;
                }
            }
        };
        Looper.loop();
    }
}