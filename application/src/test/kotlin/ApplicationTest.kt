import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import me.freedom4live.blog.application.auth.loginTestAccount
import me.freedom4live.blog.application.auth.runWithTestUser
import me.freedom4live.blog.application.module
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ApplicationTest {

    //TODO: Will be changed after user service supporting implemented
    @Test
    fun loginTest() {
        withTestApplication({ module(testing = true) }) {
            loginTestAccount()
        }
    }

    @Test
    fun meData_noAuth_Unauthorized() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/me").apply {
                assertEquals(HttpStatusCode.Unauthorized, response.status())
            }
        }
    }

    @Test
    fun meData_hasAuth_ReturnsOkAndData() {
        withTestApplication({ module(testing = true) }) {
            runWithTestUser {
                handleRequest(HttpMethod.Get, "/me").apply {
                    assertEquals(HttpStatusCode.OK, response.status())
                    assertNotNull(response.content)
                }
            }
        }
    }

}
