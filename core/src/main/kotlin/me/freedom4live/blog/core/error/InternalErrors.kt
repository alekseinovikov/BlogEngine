package me.freedom4live.blog.core.error

open class UnexpectedException : RuntimeException()
class UnexpectedNullException : UnexpectedException()

fun <T> T?.mustNotBeNull() = this ?: throw UnexpectedNullException()