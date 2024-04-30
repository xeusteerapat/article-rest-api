package com.xeus.restApiAuthDemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
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
