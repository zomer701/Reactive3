package com.example.reactive;

import com.example.reactive.model.User;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Part09Adapt {
    // TODO Adapt Flux to RxJava Flowable
    Flowable<User> fromFluxToFlowable(Flux<User> flux) {
        return Flowable.fromPublisher(flux);
    }

    // TODO Adapt RxJava Flowable to Flux
    Flux<User> fromFlowableToFlux(Flowable<User> flowable) {
        return Flux.from(flowable);
    }

//========================================================================================

    // TODO Adapt Flux to RxJava Observable
    Observable<User> fromFluxToObservable(Flux<User> flux) {
        return Observable.fromPublisher(flux);
    }

    // TODO Adapt RxJava Observable to Flux
    Flux<User> fromObservableToFlux(Observable<User> observable) {
        return Flux.from(observable.toFlowable(BackpressureStrategy.BUFFER)); // TO BE REMOVED

    }

//========================================================================================

    // TODO Adapt Mono to RxJava Single
    Single<User> fromMonoToSingle(Mono<User> mono) {
        return Flowable.fromPublisher(mono).firstOrError();
    }

    // TODO Adapt RxJava Single to Mono
    Mono<User> fromSingleToMono(Single<User> single) {
        return Mono.from(single.toFlowable());
    }

//========================================================================================

    // TODO Adapt Mono to Java 8+ CompletableFuture
    CompletableFuture<User> fromMonoToCompletableFuture(Mono<User> mono) {
        return mono.toFuture();
    }

    // TODO Adapt Java 8+ CompletableFuture to Mono
    Mono<User> fromCompletableFutureToMono(CompletableFuture<User> future) {
        return Mono.fromFuture(future);
    }
}
