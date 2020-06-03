package me.freedom4live.blog.core.model

typealias UserId = Long
typealias UserRole = String

data class User(
    val id: UserId,
    val name: String,
    val email: String,
    val roles: List<UserRole>
)