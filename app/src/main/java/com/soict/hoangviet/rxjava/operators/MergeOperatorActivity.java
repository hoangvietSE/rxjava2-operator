package com.soict.hoangviet.rxjava.operators;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MergeOperatorActivity extends BaseOperatorActivity {
    /*
     * Combine many Observable and emit items but not be in order
     */
    @Override
    protected void doSomeWork() {
        Observable.merge(
                Observable.interval(1, TimeUnit.SECONDS).map(id -> "A" + id).take(3),
                Observable.interval(1, TimeUnit.SECONDS).map(id -> "B" + id).take(2))
                .subscribe(response -> {
                    showLog(response);
                }, throwable -> {
                    handleThrowable(throwable);
                });
//        Observable
//                .merge(getFirstObservable(), getSecondObservable())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(response -> {
//                    showLog(response);
//                }, throwable -> {
//                    handleThrowable(throwable);
//                });
    }

    private Observable<String> getFirstObservable() {
        return Observable.fromArray(new String[]{"A11", "A12", "A13", "A14"});
    }

    private Observable<String> getSecondObservable() {
        return Observable.fromArray(new String[]{"A1", "A2", "A3", "A4"});
    }
}
