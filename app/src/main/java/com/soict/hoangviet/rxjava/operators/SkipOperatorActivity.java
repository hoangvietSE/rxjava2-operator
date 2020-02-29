package com.soict.hoangviet.rxjava.operators;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SkipOperatorActivity extends BaseOperatorActivity {
    @Override
    protected void doSomeWork() {
        getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .skip(2)
                .subscribe(response -> {
                    showLog(response);
                }, throwable -> {
                    handleThrowable(throwable);
                });
    }

    private Observable<Integer> getObservable() {
        return Observable.defer(() -> Observable.just(1, 2, 3, 4, 5, 6));
    }
}
