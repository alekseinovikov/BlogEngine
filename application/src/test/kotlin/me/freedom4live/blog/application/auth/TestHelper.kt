package me.freedom4live.blog.application.auth

import io.ktor.http.*
import io.ktor.server.testing.TestApplicationEngine
import io.ktor.server.testing.cookiesSession
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.setBody
import me.freedom4live.blog.application.config.FormFields
import kotlin.test.assertEquals

fun TestApplicationEngine.loginTestAccount() {
    handleRequest(HttpMethod.Post, "/login") {
        addHeader(HttpHeaders.ContentType, ContentType.Application.FormUrlEncoded.toString())
        setBody(
            listOf(
                FormFields.USERNAME to "test_user",
                FormFields.PASSWORD to "test_password"
            ).formUrlEncode()
        )
    }.apply {
        assertEquals(HttpStatusCode.OK, response.status())
        assertEquals("OK", response.content)
    }
}

fun TestApplicationEngine.runWithTestUser(test: TestApplicationEngine.() -> Unit) =
    cookiesSession {
        loginTestAccount()

        test()
    }