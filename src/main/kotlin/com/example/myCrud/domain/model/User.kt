package com.example.myCrud.domain.model

import com.example.myCrud.presentation.dto.UserResponseDto
import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val email: String,
)

fun User.toResponse() =
    UserResponseDto(
        id = this.id,
        name = this.name,
        email = this.email
    )
