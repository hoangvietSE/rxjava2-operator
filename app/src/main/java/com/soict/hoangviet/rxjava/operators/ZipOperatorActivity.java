package com.soict.hoangviet.rxjava.operators;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.soict.hoangviet.rxjava.model.User;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ZipOperatorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doSomeWork();
    }

    @SuppressLint("CheckResult")
    private void doSomeWork() {
        Observable.zip(getFullNameObservable(), getAgeObservable(),
                (fullName, age) -> new User(fullName, age))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(user -> {
                    Log.d("myLog", user.getFullName());
                    Log.d("myLog", String.valueOf(user.getAge()));
                }, throwable -> {
                    Log.e("myLog", throwable.getMessage());
                });
    }

    private Observable<String> getFullNameObservable() {
        return Observable.fromCallable(() -> "HoangVietSE");
    }

    private Observable<Integer> getAgeObservable() {
        return Observable.fromCallable(() -> 22);
    }
}
