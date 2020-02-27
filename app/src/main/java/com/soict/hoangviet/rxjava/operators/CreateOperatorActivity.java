package com.soict.hoangviet.rxjava.operators;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CreateOperatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doSomeWork();
    }

    @SuppressLint("CheckResult")
    private void doSomeWork() {
        Observable.create(emitter -> {
            for (int index = 0; index < 5; index++) {
                if (!emitter.isDisposed()) {
                    emitter.onNext("HoangVietSE");
                }
            }
            if (!emitter.isDisposed()) {
                emitter.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        result -> {
                            Log.d("myLog", String.valueOf(result));
                        },
                        throwable -> {
                        }
                );
    }
}
