package com.xeus.restApiAuthDemo.service

import com.xeus.restApiAuthDemo.model.User
import com.xeus.restApiAuthDemo.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService (
    private val userRepository: UserRepository
) {
    fun createUser(user: User): User? {
        val foundUser = userRepository.findByEmail(user.email)

        return  if (foundUser == null) {
            userRepository.save(user)
            user
        } else null
    }

    fun findById(id: UUID): User? = userRepository.findById(id)

    fun findAll(): List<User> = userRepository.findAll()

    fun deleteById(id: UUID): Boolean = userRepository.deleteById(id)
}