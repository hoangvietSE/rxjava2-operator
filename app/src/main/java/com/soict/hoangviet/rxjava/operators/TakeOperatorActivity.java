package com.soict.hoangviet.rxjava.operators;

import android.annotation.SuppressLint;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TakeOperatorActivity extends BaseOperatorActivity {
    @SuppressLint("CheckResult")
    @Override
    protected void doSomeWork() {
        getObservable()
                .take(3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        response -> {
                            showLog(response);
                        }, throwable -> {
                            handleThrowable(throwable);
                        });
    }

    private Observable<Integer> getObservable() {
        return Observable.just(1, 2, 3, 4, 5, 6);
    }
}
