package me.freedom4live.blog.application.routing

import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.StatusPages
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Routing
import me.freedom4live.blog.core.error.AuthenticationException
import me.freedom4live.blog.core.error.AuthorizationException
import me.freedom4live.blog.core.error.UnexpectedException


internal fun Routing.errorRoute() {
    install(StatusPages) {
        exception<AuthenticationException> { cause ->
            call.respond(HttpStatusCode.Unauthorized)
        }
        exception<AuthorizationException> { cause ->
            call.respond(HttpStatusCode.Forbidden)
        }
        exception<UnexpectedException> {cause ->
            call.respond(HttpStatusCode.InternalServerError)
        }
    }
}
