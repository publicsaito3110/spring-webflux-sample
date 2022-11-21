package com.springwebflux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.Rendering;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class Thymeleaf1Controller {


	/**
	 * Flux + Thymleafを使ったAPI
	 *
	 * <p>Mono + Rendaringを使った方法<br>
	 * Monoに表示する値とView名(ModelAndViewに相当するもの)をセットする<br>
	 * ただし、Monoのみこの方法は有効なため、Fluxにするコンパイルは通るがエラーになる
	 * </p>
	 *
	 * 返却値: [count: 0, count: 1, count: 2, count: 3, count: 4]
	 *
	 * @return Mono
	 */
	@RequestMapping("/thy11")
	public Mono<Rendering> thy11(Model model) {

		// Viewに表示する値
		String[] countArray = {"count: 0", "count: 1", "count: 2", "count: 3", "count: 4"};

		// 表示するViewと値をセットする
		Mono<Rendering> mono = Mono.just(Rendering.view("hello").modelAttribute("flux", countArray).build());
		return mono;
	}


	/**
	 * Flux + Thymleafを使ったAPI
	 * (Data-Driven Mode: データ駆動モード)
	 *
	 * <p>Flux + Modelを使った方法
	 * 値が取得できたものから順にクライアントサイドに返す<br>
	 * ただし、Modelに追加できるReactiveDataDriverContextVariableは1つのみで、2つ以上追加するとエラーになる
	 * </p>
	 *
	 * 返却値: [count: 0, count: 1, count: 2, count: 3, count: 4]<br>
	 * ※"Spring WebFlux"にはModelAndViewは用意されていない
	 *
	 * @return String
	 */
	@RequestMapping("/thy12")
	public String thy12(Model model) {

		// Fluxを使ったStream
		Flux<String> flux = Flux
				// 0から4までループ
				.range(0, 5)
				// iを定義し、格納
				.map(i -> "count: " + String.valueOf(i));

		// ReactiveDataDriverContextVariableでラップすると、Data-Driven Modeとなり、処理が終了した値から返される
		model.addAttribute("flux", new ReactiveDataDriverContextVariable(flux));
		return "hello";
	}
}
