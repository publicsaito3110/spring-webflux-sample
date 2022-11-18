package com.springwebflux.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;

import reactor.core.publisher.Flux;

@Controller
public class ThymeleafController {


	/**
	 * Flux + Thymleafを使ったAPI
	 *
	 * 返却値: [0, 1, 2, 3, 4]
	 *
	 * ※"Spring WebReactor"にはModelAndViewは用意されていない
	 *
	 * @return Mono
	 */
	@RequestMapping("/hello31")
	public String hello31(Model model) {

		// Fluxを使ったStream
		Flux<String> flux = Flux
				// 0から4までループ
				.range(0, 5)
				// iを定義し、格納
				.map(i -> "count: " + String.valueOf(i));

		//
		model.addAttribute("flux", new ReactiveDataDriverContextVariable(flux));
		return "hello";
	}
}
