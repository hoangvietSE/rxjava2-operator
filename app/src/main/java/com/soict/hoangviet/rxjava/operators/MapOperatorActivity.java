package com.soict.hoangviet.rxjava.operators;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MapOperatorActivity extends BaseOperatorActivity {
    @SuppressLint("CheckResult")
    protected void doSomeWork() {
        getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(integer -> String.valueOf(integer))
                .subscribe(
                        response -> {
                            showLog(response);
                        },
                        throwable -> {
                            handleThrowable(throwable);
                        }
                );
    }

    private Observable<Integer> getObservable() {
        return Observable.fromCallable(() -> 9001);
    }
}
