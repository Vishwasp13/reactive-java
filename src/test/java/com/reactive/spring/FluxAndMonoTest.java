package com.reactive.spring;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

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
	@Test
	public void fluxTestElementsWithoutError() {
		Flux<String> veryFlux = 
				Flux.just("Spring","Spring Boot","Reactive Streams")
				.log();
		
		StepVerifier.create(veryFlux)
		.expectNext("Spring")
		.expectNext("Spring Boot")
		.expectNext("Reactive Streams")
		.verifyComplete();
		}
	
	@Test
	public void monoTest() {
		Mono<String> mono= Mono.just("Spring Boot");
		StepVerifier.create(mono.log())
		.expectNext("Spring Boot")
		.verifyComplete();
		
	}
	
	@Test
	public void monoTestError() {
		StepVerifier.create(Mono.error(new RuntimeException("Exception Occurred")).log())
		.expectError(RuntimeException.class)
		.verify();
	}
}
