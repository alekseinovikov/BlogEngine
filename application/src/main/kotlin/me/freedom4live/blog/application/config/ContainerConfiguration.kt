package me.freedom4live.blog.application.config

import io.ktor.application.Application
import io.ktor.sessions.SessionStorage
import io.ktor.sessions.SessionStorageMemory
import me.freedom4live.blog.service.config.configureService
import me.freedom4live.blog.storage.config.configureStorage
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

fun Application.configureContainer(testing: Boolean) = Kodein {
    import(configureStorage(testing))
    import(configureService(testing))
    import(configureWebApplication(testing))
}

fun Kodein.MainBuilder.configureWebApplication(testing: Boolean) = Kodein.Module("WebApplication") {
    if (testing.not()) {
        configureNotTesting()
    } else {
        configureTesting()
    }
}

private fun Kodein.Builder.configureNotTesting() {

}

private fun Kodein.Builder.configureTesting() {
    bind<SessionStorage>() with singleton { SessionStorageMemory() }
}