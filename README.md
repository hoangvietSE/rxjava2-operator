## Rxjava Operator
1. **Map**: It transforms the items emitted by an Observable by applying a function to each item.
2. **Zip**: It combines the emissions of multiple Observables together via a specified function, then emits a single item for each combination based on the results of this function.
3. **Filter**: It emits only those items from an Observable that pass a predicate test.
4. **FlatMap**: It transforms the items emitted by an Observable into Observables, then flattens the emissions from those into a single Observable.
5. **Take**: It emits only the first n items emitted by an Observable.
6. **Reduce**: It applies a function to each item emitted by an Observable, sequentially, and emits the final value.
7. **Skip**: It suppresses the first n items emitted by an Observable.
8. **Buffer**: It periodically gathers items emitted by an Observable into bundles and emits these bundles rather than emitting the items one at a time.
9. **Concat**: It emits the emissions from two or more Observables without interleaving them.
10. **Replay**: It ensures that all observers see the same sequence of emitted items, even if they subscribe after the Observable has begun emitting items.
11. **Merge**: It combines multiple Observables into one by merging their emissions.
