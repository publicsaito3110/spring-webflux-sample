package com.springwebflux.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Rest3Controller {


	/**
	 * Fluxを使った並列処理を実装したRestAPI
	 *
	 * <p>並列処理:<br>
	 * リクエスト -> [処理1] & [処理2] -> レスポンス
	 * </p>
	 *
	 * 返却値: Hello World!
	 *
	 * @return Mono
	 */
	@RequestMapping("/rest21")
	public Flux<String> rest21() {

//		Mono.zip(
//				Flux
//				//
//				.range(0, 5)
//				// [処理1] iを定義し、intで格納 (この時点では型が不整合でエラーになる)
//				.map(i -> "count: " + String.valueOf(i)),
//
//				Flux
//				.range(5, 10)
//				.map(j -> "count: " + String.valueOf(j))
//				)
		.







				return null;
	}
}
