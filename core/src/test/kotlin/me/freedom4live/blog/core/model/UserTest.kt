package me.freedom4live.blog.core.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserTest {

    @Test
    fun testEquals_equal_equals() {
        //arrange
        val user1 = User(42L, "userName", "email", listOf("role"))
        val user2 = User(42L, "userName", "email", listOf("role"))

        //assert
        assertThat(user1).isEqualTo(user2)
    }

    @Test
    fun testEquals_diffId_notEquals() {
        //arrange
        val user1 = User(42L, "userName", "email", listOf("role"))
        val user2 = User(43L, "userName", "email", listOf("role"))

        //assert
        assertThat(user1).isNotEqualTo(user2)
    }

    @Test
    fun testEquals_diffName_notEquals() {
        //arrange
        val user1 = User(42L, "userName", "email", listOf("role"))
        val user2 = User(42L, "userName2", "email", listOf("role"))

        //assert
        assertThat(user1).isNotEqualTo(user2)
    }

    @Test
    fun testEquals_diffEmail_notEquals() {
        //arrange
        val user1 = User(42L, "userName", "email", listOf("role"))
        val user2 = User(42L, "userName", "email2", listOf("role"))

        //assert
        assertThat(user1).isNotEqualTo(user2)
    }

    @Test
    fun testEquals_diffRoles_notEquals() {
        //arrange
        val user1 = User(42L, "userName", "email", listOf("role"))
        val user2 = User(42L, "userName", "email", listOf("role", "role2"))

        //assert
        assertThat(user1).isNotEqualTo(user2)
    }

    @Test
    fun testHashCode_equals_equalHashCodes() {
        //arrange
        val user1 = User(42L, "userName", "email", listOf("role"))
        val user2 = User(42L, "userName", "email", listOf("role"))

        //assert
        assertThat(user1.hashCode()).isEqualTo(user2.hashCode())
    }

    @Test
    fun testToString_fields_toStringNoStackOverflow() {
        //arrange
        val user = User(42L, "userName", "email", listOf("role"))

        //act
        val stringRepresentation = user.toString()

        //assert
        assertThat(stringRepresentation).isEqualTo("User(id=42, name='userName', email='email', roles=[role])")
    }

}