package com.example.looperdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    public final static String TAG = "HjlTest";
    private Button mthreadA;
    private Button mthreadB;
    private TextView mTextView;
    private CheckBox mCheckBox;

    public ThreadB threadB = new ThreadB();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mthreadA = findViewById(R.id.mthreadA);
        mthreadB = findViewById(R.id.mthreadB);
        mCheckBox = findViewById(R.id.mcheckbox);

        mthreadA.setOnLongClickListener(this);
        mthreadB.setOnLongClickListener(this);

        mTextView = findViewById(R.id.textview);


        ThreadA threadA = new ThreadA();
        new Thread(threadA).start();
        if (threadA.getHandler() == null) {
            try {
                Thread.sleep(1000);
                mHandler = threadA.getHandler();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    Handler mHandler;

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.mthreadA:
                mTextView.setText("aaa");
                mCheckBox.setVisibility(View.VISIBLE);
                new Thread(threadB).start();

                break;
            case R.id.mthreadB:
                ;
                break;
            default:
                break;
        }
        return true;
    }

}
