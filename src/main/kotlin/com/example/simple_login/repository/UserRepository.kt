package com.example.demo.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.User

interface UserRepository : JpaRepository<User, Long> {
    fun findByUsername(username: String): User?
}