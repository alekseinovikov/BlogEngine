package me.freedom4live.blog.core.model

typealias UserId = Long
typealias UserRole = String

open class User(
    val id: UserId,
    val name: String,
    val email: String,
    val roles: List<UserRole>
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is User) return false

        if (id != other.id) return false
        if (name != other.name) return false
        if (email != other.email) return false
        if (roles != other.roles) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + roles.hashCode()
        return result
    }

    override fun toString(): String {
        return "User(id=$id, name='$name', email='$email', roles=$roles)"
    }

}