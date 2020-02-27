package com.soict.hoangviet.rxjava.operators;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;

public class DeferOperatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        doSomeWork();
    }

    @SuppressLint("CheckResult")
    private void doSomeWork() {
        Car car = new Car();

        Observable defaultObservable = car.getDefaultObservable();
        Observable deferObservable = car.getDeferObservable();

        car.brand = "BWM";

        defaultObservable.subscribe(brand -> {
            try {
                Log.d("myLog", String.valueOf(brand));
            } catch (Exception e) {

            }
        });
        deferObservable.subscribe(brand -> {
            try {
                Log.d("myLog", String.valueOf(brand));
            } catch (Exception e) {

            }
        });
    }

    private class Car {
        private String brand = "Vinfast";

        public Observable getDefaultObservable() {
            return Observable.just(brand);
        }

        public Observable getDeferObservable() {
            return Observable.defer(() -> Observable.just(brand));
        }
    }
}
