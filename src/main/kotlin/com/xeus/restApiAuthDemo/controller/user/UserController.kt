package com.xeus.restApiAuthDemo.controller.user

import com.xeus.restApiAuthDemo.model.Role
import com.xeus.restApiAuthDemo.model.User
import com.xeus.restApiAuthDemo.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) {
    @PostMapping
    fun create(@RequestBody userRequest: UserRequest): UserResponse =
        userService.createUser(
        user = userRequest.toModel()
    ) ?.toResponse()
            ?: throw ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot create a user.")

    @GetMapping
    fun listAll(): List<UserResponse> = userService.findAll().map { it.toResponse() }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: UUID): UserResponse =
        userService.findById(id)
            ?.toResponse()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find a user.")

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: UUID): ResponseEntity<Boolean> {
        val success = userService.deleteById(id)

        return if (success) ResponseEntity.noContent().build()
            else throw ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find a user.")
    }

    private fun UserRequest.toModel(): User = User(
        id = UUID.randomUUID(),
        email = this.email,
        password = this.password,
        role = Role.USER
    )

    private fun User.toResponse(): UserResponse = UserResponse(
        id = this.id,
        email = this.email
    )
}