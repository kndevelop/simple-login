package com.example.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AuthController {
    @GetMapping("/login")
    fun loginPage(): String = "login"

    @GetMapping("/home")
    fun home(): String = "home"
}