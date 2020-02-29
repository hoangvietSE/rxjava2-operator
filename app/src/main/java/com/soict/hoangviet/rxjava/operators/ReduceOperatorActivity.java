package com.soict.hoangviet.rxjava.operators;

import io.reactivex.Observable;

public class ReduceOperatorActivity extends BaseOperatorActivity {
    @Override
    protected void doSomeWork() {
        getObservable()
                .reduce((integer, integer2) -> integer - integer2)
                .subscribe(response -> {
                    showLog(response);
                }, throwable -> {
                    handleThrowable(throwable);
                });
    }

    private Observable<Integer> getObservable() {
        return Observable.just(1, 2, 3, 4);
    }
}
