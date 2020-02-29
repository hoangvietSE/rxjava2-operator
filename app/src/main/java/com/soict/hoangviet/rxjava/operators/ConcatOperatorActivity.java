package com.soict.hoangviet.rxjava.operators;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ConcatOperatorActivity extends BaseOperatorActivity {
    /*
     * Combine many Observable and emit items in order
     */
    @Override
    protected void doSomeWork() {
        Observable
                .concat(getFirstObservable(), getSecondObservable())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    showLog(response);
                }, throwable -> {
                    handleThrowable(throwable);
                });
    }

    private Observable<String> getFirstObservable() {
        return Observable.fromArray(new String[]{"A11", "A12"});
    }

    private Observable<String> getSecondObservable() {
        return Observable.fromArray(new String[]{"A13", "A14"});
    }
}
