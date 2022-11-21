package com.springwebflux.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Rest1Controller {


	/**
	 * Monoを使ったシンプルなRestAPI
	 *
	 * <p>単一処理:<br>
	 * リクエスト -> [処理] -> レスポンス
	 * </p>
	 *
	 * 返却値: Hello World!
	 *
	 * @return Mono
	 */
	@RequestMapping("/rest11")
	public Mono<String> rest11() {

		// Monoは単一のオブジェクトのみStreamできる
		return Mono.just("Hello World!");
	}


	/**
	 * Fluxを使ったシンプルなRestAPI
	 *
	 * <p>単一処理:<br>
	 * リクエスト -> [処理] -> レスポンス
	 * </p>
	 * 返却値: Hello World! WebFlux
	 *
	 * @return Flux
	 */
	@RequestMapping("/rest12")
	public Flux<String> rest12() {

		// Fluxは複数のオブジェクトをStreamできる
		return Flux.just("Hello World!", "WebFlux");
	}


	/**
	 * Fluxを使ったRestAPI
	 *
	 * <p>単一処理:<br>
	 * リクエスト -> [処理] -> レスポンス
	 * </p>
	 *
	 * 返却値: [0, 1, 2, 3, 4]
	 *
	 * @return Flux
	 */
	@RequestMapping("/rest13")
	public Flux<Integer> rest13() {

		// Fluxを使ったStream
		Flux<Integer> flux = Flux
				// 0から4までループ
				.range(0, 5)
				// iを定義し、格納
				.map(i -> i);

		return flux;
	}
}
