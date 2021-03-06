package com.soict.hoangviet.rxjava.operators;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class FilterOperatorActivity extends BaseOperatorActivity {
    @SuppressLint("CheckResult")
    protected void doSomeWork() {
        getObservable()
                .filter(integer -> integer % 2 == 0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                    showLog(result);
                }, throwable -> {
                    handleThrowable(throwable);
                });

    }

    private Observable<Integer> getObservable() {
        return Observable.just(1, 2, 3, 4, 5, 6);
    }
}
