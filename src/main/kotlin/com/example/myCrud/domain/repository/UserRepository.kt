package com.example.myCrud.domain.repository

import com.example.myCrud.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>