package com.xeus.restApiAuthDemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class RestApiAuthDemoApplication

fun main(args: Array<String>) {
	runApplication<RestApiAuthDemoApplication>(*args)
}

@RestController
class MessageController {
	@GetMapping("/")
	fun index(): String = "Hello World"
}

@Configuration
@EnableWebSecurity
class SecurityConfig {

	@Bean
	fun webSecurityCustomizer(): WebSecurityCustomizer {
		return WebSecurityCustomizer {
			it
				.ignoring()
				.requestMatchers("/")
				.anyRequest()
		}
	}
}