package com.example.simple_login.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "username", unique = true, nullable = false)
    var username: String = "",

    @Column(name = "password", nullable = false)
    var password: String = ""
)