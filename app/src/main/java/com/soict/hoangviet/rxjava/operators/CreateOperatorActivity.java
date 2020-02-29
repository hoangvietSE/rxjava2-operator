package com.soict.hoangviet.rxjava.operators;

import android.annotation.SuppressLint;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CreateOperatorActivity extends BaseOperatorActivity {

    @SuppressLint("CheckResult")
    protected void doSomeWork() {
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
                            showLog(result);
                        },
                        throwable -> {
                            handleThrowable(throwable);
                        }
                );
    }
}
