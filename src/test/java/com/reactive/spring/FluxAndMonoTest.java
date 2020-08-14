package com.reactive.spring;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;

public class FluxAndMonoTest {

	@Test
	public void fluxTest() {
		Flux<String> veryFlux = 
				Flux.just("Spring","Spring Boot","Reactive Streams")
				//.concatWith(Flux.error(new RuntimeException("Exception Occured")))
				.concatWith(Flux.just("After Error"))
				.log();
		veryFlux.subscribe(System.out::println, (e) -> System.err.println("Code breaks "+e), () -> System.out.println("Completed"));
	}
}
