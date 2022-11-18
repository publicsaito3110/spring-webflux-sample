package com.springwebflux.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class SimpleRestController {


	/**
	 * Monoを使ったシンプルなRestAPI
	 *
	 * 返却値: Hello World!
	 *
	 * @return Mono
	 */
	@RequestMapping("/hello11")
	public Mono<String> hello11() {

		// Monoは単一のオブジェクトのみStreamできる
		return Mono.just("Hello World!");
	}


	/**
	 * Fluxを使ったシンプルなRestAPI
	 *
	 * 返却値: Hello World! WebFlux
	 *
	 * @return Mono
	 */
	@RequestMapping("/hello21")
	public Flux<String> hello21() {

		// Fluxは複数のオブジェクトをStreamできる
		return Flux.just("Hello World!", "WebFlux");
	}


	/**
	 * Fluxを使ったRestAPI
	 *
	 * 返却値: [0, 1, 2, 3, 4]
	 *
	 * @return Mono
	 */
	@RequestMapping("/hello22")
	public Flux<Integer> hello22() {

		// Fluxを使ったStream
		Flux<Integer> flux = Flux
				// 0から4までループ
				.range(0, 5)
				// iを定義し、格納
				.map(i -> i);

		return flux;
	}
}
