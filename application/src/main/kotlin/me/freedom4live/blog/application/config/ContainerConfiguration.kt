package me.freedom4live.blog.application.config

import io.ktor.application.Application
import me.freedom4live.blog.storage.config.configureStorage
import me.freedom4live.blog.service.config.configureService
import org.kodein.di.Kodein

fun Application.configureContainer(testing: Boolean) = Kodein {
    import(configureStorage(testing))
    import(configureService(testing))
}