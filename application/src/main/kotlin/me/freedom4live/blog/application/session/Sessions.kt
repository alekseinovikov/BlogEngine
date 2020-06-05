package me.freedom4live.blog.application.session

import io.ktor.sessions.SessionStorage
import io.ktor.sessions.Sessions
import io.ktor.sessions.cookie
import me.freedom4live.blog.application.auth.UserPrincipal
import me.freedom4live.blog.application.config.Cookies

fun Sessions.Configuration.configureAuthCookie(sessionStorage: SessionStorage) {
    cookie<UserPrincipal>(
        Cookies.AUTH_COOKIE,
        storage = sessionStorage
    ) {
        cookie.path = "/"
        cookie.extensions["SameSite"] = "lax"
    }
}