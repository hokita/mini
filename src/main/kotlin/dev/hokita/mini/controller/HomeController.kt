package dev.hokita.mini.controller

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
class HomeController {
    @Value("\${my.name}")
    val name: String = "Karashi"

    @Value("\${my.age}")
    val age: Int = 4

    data class User(
        val name: String,
        val age: Int,
        val now: LocalDateTime
    )

    @GetMapping("/")
    suspend fun homeGet(): User {
        return User(name, age, LocalDateTime.now())
    }
}
