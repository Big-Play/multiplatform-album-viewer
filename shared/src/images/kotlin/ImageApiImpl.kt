import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ImageApiImpl(private val httpClient: HttpClient) : ImageApi {
    override suspend fun fetchImage(url: String): ByteArray? {
        return httpClient.use { client -> client.get(url).body() }
    }
}