package com.soict.hoangviet.rxjava.operators;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;

public class DeferOperatorActivity extends BaseOperatorActivity {
    @SuppressLint("CheckResult")
    protected void doSomeWork() {
        Car car = new Car();

        Observable defaultObservable = car.getDefaultObservable();
        Observable deferObservable = car.getDeferObservable();

        car.brand = "BWM";

        defaultObservable.subscribe(brand -> {
            try {
                showLog(brand);
            } catch (Exception e) {

            }
        });
        deferObservable.subscribe(brand -> {
            try {
                showLog(brand);
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
