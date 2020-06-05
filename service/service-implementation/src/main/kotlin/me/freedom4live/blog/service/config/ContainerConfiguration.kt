package me.freedom4live.blog.service.config

import me.freedom4live.blog.service.UserService
import me.freedom4live.blog.service.UserServiceImpl
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

fun Kodein.MainBuilder.configureService(testing: Boolean) = Kodein.Module("serviceModule") {
    if (testing.not()) {
        configureNotTesting()
    } else {

    }
}

private fun Kodein.Builder.configureNotTesting() {
    bind<UserService>() with singleton { UserServiceImpl() }
}

private fun Kodein.Builder.configureTesting() {

}