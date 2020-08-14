package com.reactive.spring;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
@RestController
public class ReactiveController {
	
	@GetMapping(path = "/hello", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<String> hello(){
		
		return Flux.just("Hello ","World ","This ","Is ","My ","First ","Reactive ","API ").delayElements(Duration.ofMillis(1000)).log();
	} 

}
