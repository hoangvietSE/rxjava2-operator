package com.soict.hoangviet.rxjava.operators;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseOperatorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doSomeWork();
    }

    protected abstract void doSomeWork();

    protected void handleThrowable(Throwable throwable) {
        Log.e("myLog", throwable.getMessage());
    }

    protected void showLog(Object response) {
        try {
            Log.d("myLog", String.valueOf(response));
        } catch (Exception e) {
        }
    }
}
