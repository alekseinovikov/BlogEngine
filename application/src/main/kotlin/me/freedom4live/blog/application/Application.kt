package me.freedom4live.blog.application

import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.features.ConditionalHeaders
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
import io.ktor.routing.routing
import io.ktor.sessions.SessionStorage
import io.ktor.sessions.Sessions
import me.freedom4live.blog.application.auth.configureFormAuth
import me.freedom4live.blog.application.auth.configureSessionAuth
import me.freedom4live.blog.application.config.configureContainer
import me.freedom4live.blog.application.routing.authRoute
import me.freedom4live.blog.application.routing.errorRoute
import me.freedom4live.blog.application.session.configureAuthCookie
import org.kodein.di.generic.instance

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val di = configureContainer(testing)
    val sessionStorage by di.instance<SessionStorage>()

    install(ConditionalHeaders)
    install(Sessions) {
        configureAuthCookie(sessionStorage)
    }

    install(Authentication) {
        configureSessionAuth()
        configureFormAuth()
    }

    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    routing {
        errorRoute()
        authRoute()
    }
}


