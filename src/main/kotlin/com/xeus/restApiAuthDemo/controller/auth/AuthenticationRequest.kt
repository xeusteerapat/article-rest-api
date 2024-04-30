package com.xeus.restApiAuthDemo.controller.auth

data class AuthenticationRequest(
    val email: String,
    val password: String
)
