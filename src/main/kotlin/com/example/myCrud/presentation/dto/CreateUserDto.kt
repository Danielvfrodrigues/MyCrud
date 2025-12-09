package com.example.myCrud.presentation.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class CreateUserDto(
    @field:NotBlank val name: String,
    @field:Email val email: String,
)
