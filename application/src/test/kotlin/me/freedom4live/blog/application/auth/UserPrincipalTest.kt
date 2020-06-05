package me.freedom4live.blog.application.auth

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class UserPrincipalTest {

    @Test
    fun testEquals_equal_equals() {
        //arrange
        val user1 = UserPrincipal(42L, "userName", "email", listOf("role"))
        val user2 = UserPrincipal(42L, "userName", "email", listOf("role"))

        //assert
        Assertions.assertThat(user1).isEqualTo(user2)
    }

    @Test
    fun testEquals_diffId_notEquals() {
        //arrange
        val user1 = UserPrincipal(42L, "userName", "email", listOf("role"))
        val user2 = UserPrincipal(43L, "userName", "email", listOf("role"))

        //assert
        Assertions.assertThat(user1).isNotEqualTo(user2)
    }

    @Test
    fun testEquals_diffName_notEquals() {
        //arrange
        val user1 = UserPrincipal(42L, "userName", "email", listOf("role"))
        val user2 = UserPrincipal(42L, "userName2", "email", listOf("role"))

        //assert
        Assertions.assertThat(user1).isNotEqualTo(user2)
    }

    @Test
    fun testEquals_diffEmail_notEquals() {
        //arrange
        val user1 = UserPrincipal(42L, "userName", "email", listOf("role"))
        val user2 = UserPrincipal(42L, "userName", "email2", listOf("role"))

        //assert
        Assertions.assertThat(user1).isNotEqualTo(user2)
    }

    @Test
    fun testEquals_diffRoles_notEquals() {
        //arrange
        val user1 = UserPrincipal(42L, "userName", "email", listOf("role"))
        val user2 = UserPrincipal(42L, "userName", "email", listOf("role", "role2"))

        //assert
        Assertions.assertThat(user1).isNotEqualTo(user2)
    }

    @Test
    fun testHashCode_equals_equalHashCodes() {
        //arrange
        val user1 = UserPrincipal(42L, "userName", "email", listOf("role"))
        val user2 = UserPrincipal(42L, "userName", "email", listOf("role"))

        //assert
        Assertions.assertThat(user1.hashCode()).isEqualTo(user2.hashCode())
    }

    @Test
    fun testToString_fields_toStringNoStackOverflow() {
        //arrange
        val user = UserPrincipal(42L, "userName", "email", listOf("role"))

        //act
        val stringRepresentation = user.toString()

        //assert
        Assertions.assertThat(stringRepresentation)
            .isEqualTo("User(id=42, name='userName', email='email', roles=[role])")
    }

}