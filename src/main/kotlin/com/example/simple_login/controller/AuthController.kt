package com.example.demo.controller

import com.example.simple_login.model.RegisterModel
import com.example.simple_login.entity.User
import com.example.simple_login.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class AuthController(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    @GetMapping("/login")
    fun loginPage(): String = "login"

    @GetMapping("/home")
    fun home(): String = "home"

    @GetMapping("/register")
    fun registerPage(model: Model): String {
        model.addAttribute("registerForm", RegisterModel())
        return "register"
    }

    @PostMapping("/register")
    fun register(
        @RequestParam username: String,
        @RequestParam password: String,
        model: Model
    ): String {
        // simple check for existing username
        val existing = userRepository.findByUsername(username)
        if (existing != null) {
            model.addAttribute("error", "Username already exists")
            model.addAttribute("registerForm", RegisterModel(username, ""))
            return "register"
        }

        val encoded = passwordEncoder.encode(password)
        val user = User(username = username, password = encoded)
        userRepository.save(user)

        // 登録後はログインページへリダイレクト
        return "redirect:/login"
    }
}