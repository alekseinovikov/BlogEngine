package me.freedom4live.blog.storage.config

import me.freedom4live.blog.storage.UserStorage
import me.freedom4live.blog.storage.UserStorageImpl
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

fun Kodein.MainBuilder.configureStorage(testing: Boolean) = Kodein.Module("storageModule") {
    if (testing.not()) {
        configureNotTesting()
    } else {

    }
}

private fun Kodein.Builder.configureNotTesting() {
    bind<UserStorage>() with singleton { UserStorageImpl() }
}

private fun Kodein.Builder.configureTesting() {

}