package model.remote.character

import io.ktor.client.statement.HttpResponse

interface CharacterApi {
    suspend fun fetchCharacters(): HttpResponse
}