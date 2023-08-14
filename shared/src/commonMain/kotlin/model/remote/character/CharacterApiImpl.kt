package model.remote.character

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

class CharacterApiImpl(private val client: HttpClient) : CharacterApi {
    override suspend fun fetchCharacters(): HttpResponse {
        return client.get(urlString = "/api/characters")
    }
}