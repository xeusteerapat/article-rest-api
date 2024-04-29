package com.xeus.restApiAuthDemo.controller.user

import java.util.UUID

data class UserResponse(
    val id: UUID,
    val email: String
)
