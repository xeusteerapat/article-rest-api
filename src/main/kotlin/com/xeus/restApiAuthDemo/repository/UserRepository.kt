package com.xeus.restApiAuthDemo.repository

import com.xeus.restApiAuthDemo.model.Role
import com.xeus.restApiAuthDemo.model.User
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserRepository {
    private val users = mutableListOf(
        User(
            id = UUID.randomUUID(),
            email = "johndoe@mail.com",
            password = "password1234",
            role = Role.USER
        ),
        User(
            id = UUID.randomUUID(),
            email = "admin@mail.com",
            password = "admin1234",
            role = Role.ADMIN
        ),
        User(
            id = UUID.randomUUID(),
            email = "janedoe@mail.com",
            password = "password1234",
            role = Role.USER
        ),
    )

    fun save(user: User): Boolean = users.add(user)

    fun findByEmail(email: String): User? = users.firstOrNull {
        it.email == email
    }

    fun findAll(): List<User> = users

    fun findById(id: UUID): User? = users.firstOrNull { it.id == id }

    fun deleteById(id: UUID): Boolean {
        val foundUser = findById(id)

        return  foundUser?.let {
            users.remove(it)
        } ?: false
    }
}