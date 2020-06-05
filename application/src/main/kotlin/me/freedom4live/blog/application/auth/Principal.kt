package me.freedom4live.blog.application.auth

import io.ktor.auth.Principal
import me.freedom4live.blog.core.model.User
import me.freedom4live.blog.core.model.UserId
import me.freedom4live.blog.core.model.UserRole

class UserPrincipal(
    id: UserId,
    name: String,
    email: String,
    roles: List<UserRole>
) : User(id, name, email, roles), Principal {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UserPrincipal) return false
        if (!super.equals(other)) return false
        return true
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super<User>.toString()
    }

}