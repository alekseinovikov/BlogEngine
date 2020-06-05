package me.freedom4live.blog.application.routing

import io.ktor.application.call
import io.ktor.auth.authenticate
import io.ktor.auth.principal
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route
import io.ktor.sessions.sessions
import io.ktor.sessions.set
import me.freedom4live.blog.application.auth.UserPrincipal
import me.freedom4live.blog.application.config.AuthName
import me.freedom4live.blog.core.error.mustNotBeNull

internal fun Routing.authRoute() {

    route("/login") {
        authenticate(AuthName.FORM) {
            post {
                val principal = call.principal<UserPrincipal>().mustNotBeNull()
                // Set the cookie
                call.sessions.set(principal)
                call.respond(HttpStatusCode.OK, "OK")
            }
        }
    }

    route("/me") {
        authenticate(AuthName.SESSION) {
            get {
                val principal = call.principal<UserPrincipal>().mustNotBeNull()
                call.respond(HttpStatusCode.OK, principal)
            }
        }
    }

}
