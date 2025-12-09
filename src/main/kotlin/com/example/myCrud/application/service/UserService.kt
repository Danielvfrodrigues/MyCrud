package com.example.myCrud.application.service

import com.example.myCrud.presentation.dto.CreateUserDto
import com.example.myCrud.presentation.dto.UserResponseDto
import com.example.myCrud.domain.model.User
import com.example.myCrud.domain.model.toResponse
import com.example.myCrud.domain.repository.UserRepository
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

@Service
class UserService(
    private val repository: UserRepository,
) {
    fun create(dto: CreateUserDto) = repository
        .save(User(name = dto.name, email = dto.email))
        .toResponse()

    fun getAll(): List<UserResponseDto> = repository.findAll().map { it.toResponse() }

    fun getById(id: Long): UserResponseDto = repository
        .findById(id)
        .orElseThrow { RuntimeException("User $id not found") }
        .toResponse()

    fun delete(id: Long) {
        if (!repository.existsById(id)) throw IllegalArgumentException("User $id does not exist")
        repository.deleteById(id)
    }
}