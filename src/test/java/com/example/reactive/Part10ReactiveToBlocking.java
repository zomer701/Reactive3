package com.example.reactive;

import com.example.reactive.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Part10ReactiveToBlocking {

//========================================================================================

    // TODO Return the user contained in that Mono
    User monoToValue(Mono<User> mono) {
        return mono.block();
    }

//========================================================================================

    // TODO Return the users contained in that Flux
    Iterable<User> fluxToValues(Flux<User> flux) {
        return flux.toIterable();
    }
}
