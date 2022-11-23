package com.springwebflux.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class Rest2Controller {


	/**
	 * Fluxを使った複数処理を実装したRestAPI
	 *
	 * <p>複数処理:<br>
	 * リクエスト -> [処理1] -> [処理2] -> レスポンス
	 * </p>
	 *
	 * 返却値: Hello World!
	 *
	 * @return Mono
	 */
	@RequestMapping("/rest21")
	public Flux<String> rest21() {

		Flux<String> flux = Flux
				// 0から4までループ
				.range(0, 5)
				// [処理1] iを定義し、intで格納 (この時点では型が不整合でエラーになる)
				.map(i -> i)
				// [処理2] 処理1を終了後、jを定義し、Stringで格納
				.map(j -> "count: " + j);

		return flux;
	}
}
