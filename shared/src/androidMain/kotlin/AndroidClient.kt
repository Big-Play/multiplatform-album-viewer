import co.touchlab.kermit.Logger
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel.ALL
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal object AndroidClient {

    operator fun invoke(
        json: Json,
        kermitLogger: Logger
    ) = HttpClient(OkHttp) {
        defaultRequest {
            url("https://hp-api.onrender.com")
        }
        expectSuccess = true
        install(ContentNegotiation) {
            json(json)
        }
        install(Logging) {
            level = ALL
            logger = object : io.ktor.client.plugins.logging.Logger {
                override fun log(message: String) {
                    kermitLogger.v { message }
                }
            }
        }
    }
}

actual suspend fun fetchImageAsByteArray(url: String): ByteArray {
    val client = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json(Json {
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    val httpResponse: HttpResponse = client.get(url)
    return httpResponse.body()
}