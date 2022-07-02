package com.sankha.springbootwebfluxdemo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {

    @Test
    public void testMono(){
        Mono<?> monoString = Mono.just("Sankha")
                .then(Mono.error(new RuntimeException("Exception occured...."))).log();
        monoString.subscribe(System.out::println,e-> System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux(){
         Flux<String> fluxString = Flux.just("Spring",
                 "Spring boot", "HIbernate", "Microservices").
                 concatWithValues("aws").concatWith(Flux.error(new RuntimeException("Error.... ")))
                 .concatWithValues("Cloud").log();
        fluxString.subscribe(System.out::println);
    }
}
