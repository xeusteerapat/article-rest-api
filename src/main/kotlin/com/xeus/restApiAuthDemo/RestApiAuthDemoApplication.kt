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
class AuthController {
	@GetMapping("/auth")
	fun index(@RequestParam("name") name: String) = "Hello, $name!"
}

@RestController
class MessageController {
	@GetMapping("/list")
	fun index() = listOf(
		Message("1", "Hello!"),
		Message("2", "Bonjour!"),
		Message("3", "สวัสดี!"),
	)
}

data class Message(val id: String?, val text: String)