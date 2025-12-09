package com.example.myCrud.presentation.controller

import com.example.myCrud.presentation.dto.CreateUserDto
import com.example.myCrud.application.service.UserService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(
    private val service: UserService,
) {

    @PostMapping
    fun create(@Valid @RequestBody dto: CreateUserDto) = service.create(dto)

    @GetMapping
    fun getAll() = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) = service.getById(id)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
