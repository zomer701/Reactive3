package com.example.reactive.repository;

import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactiveRepository<T> {
    public Mono<Void> save(Publisher<T> publisher) {
        return Mono.empty();
    }

    public Mono<T> findFirst() {
        return Mono.empty();
    }

    public Flux<T> findAll() {
        return Flux.empty();
    }

    public Mono<T> findById(String id) {
        return Mono.empty();
    }
}
