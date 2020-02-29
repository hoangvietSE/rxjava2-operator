package com.soict.hoangviet.rxjava.operators;

import android.annotation.SuppressLint;
import android.util.Log;

import com.soict.hoangviet.rxjava.model.User;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ZipOperatorActivity extends BaseOperatorActivity {
    @SuppressLint("CheckResult")
    protected void doSomeWork() {
        Observable.zip(getFullNameObservable(), getAgeObservable(),
                (fullName, age) -> new User(fullName, age))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> {
                    Log.d("myLog", user.getFullName());
                    Log.d("myLog", String.valueOf(user.getAge()));
                }, throwable -> {
                    handleThrowable(throwable);
                });
    }

    private Observable<String> getFullNameObservable() {
        return Observable.fromCallable(() -> "HoangVietSE");
    }

    private Observable<Integer> getAgeObservable() {
        return Observable.fromCallable(() -> 22);
    }
}
