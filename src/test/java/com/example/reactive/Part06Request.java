package com.example.reactive;

import com.example.reactive.model.User;
import com.example.reactive.repository.ReactiveRepository;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class Part06Request {

    ReactiveRepository<User> repository = new ReactiveRepository<>();

//========================================================================================

    // TODO Create a StepVerifier that initially requests all values and expect 4 values to be received
    StepVerifier requestAllExpectFour(Flux<User> flux) {
        return StepVerifier.create(flux)
                .expectNextCount(4)
                .expectComplete();
    }

//========================================================================================

    // TODO Create a StepVerifier that initially requests 1 value and expects User.SKYLER then requests another value and expects User.JESSE then stops verifying by cancelling the source
    StepVerifier requestOneExpectSkylerThenRequestOneExpectJesse(Flux<User> flux) {
        return StepVerifier.create(flux)
                .expectNext(User.SKYLER)
                .thenRequest(1)
                .expectNext(User.JESSE)
                .thenCancel();
    }

//========================================================================================

    // TODO Return a Flux with all users stored in the repository that prints automatically logs for all Reactive Streams signals
    Flux<User> fluxWithLog() {
        return repository
                .findAll()
                .log();
    }

//========================================================================================

    // TODO Return a Flux with all users stored in the repository that prints "Starring:" at first, "firstname lastname" for all values and "The end!" on complete
    Flux<User> fluxWithDoOnPrintln() {
        return repository
                .findAll()
                .doOnSubscribe(s -> System.out.println("Starring:"))
                .doOnNext(p -> System.out.println(p.getFirstname() + " " + p.getLastname()))
                .doOnComplete(() -> System.out.println("The end!"));
    }


}
