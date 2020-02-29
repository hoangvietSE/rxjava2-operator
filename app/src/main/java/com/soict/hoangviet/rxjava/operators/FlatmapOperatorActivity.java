package com.soict.hoangviet.rxjava.operators;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class FlatmapOperatorActivity extends BaseOperatorActivity {
    @SuppressLint("CheckResult")
    protected void doSomeWork() {
        getAgeObservable()
                .flatMap((Function<Integer, ObservableSource<String>>) age -> getFullNameObservable(age))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    showLog(response);
                }, throwable -> {
                    handleThrowable(throwable);
                });
    }

    private Observable<Integer> getAgeObservable() {
        return Observable.just(19);
    }

    private Observable<String> getFullNameObservable(int age) {
        if (age >= 15 && age <= 20) {
            return Observable.just("Teenager");
        } else {
            return Observable.just("Anonymous");
        }
    }
}
