package me.freedom4live.blog.application.auth

import io.ktor.auth.Authentication
import io.ktor.auth.UserPasswordCredential
import io.ktor.auth.form
import io.ktor.auth.session
import me.freedom4live.blog.application.config.AuthName
import me.freedom4live.blog.application.config.FormFields
import me.freedom4live.blog.core.error.AuthenticationException

fun Authentication.Configuration.configureSessionAuth() {
    session<UserPrincipal>(AuthName.SESSION) {
        challenge {
            // What to do if the user isn't authenticated
            throw AuthenticationException()
        }
        validate { session: UserPrincipal ->
            // If you need to do additional validation on session data, you can do so here.
            session
        }
    }
}

fun Authentication.Configuration.configureFormAuth() {
    form(AuthName.FORM) {
        userParamName = FormFields.USERNAME
        passwordParamName = FormFields.PASSWORD
        challenge {
            throw AuthenticationException()
        }
        validate { cred: UserPasswordCredential ->
            // TODO: check via specified service with DB and etc
            if (cred.name == "test_user" && cred.password == "test_password") UserPrincipal(
                42L,
                "test_user",
                "test_email",
                listOf("test_role")
            )
            else null
        }
    }
}