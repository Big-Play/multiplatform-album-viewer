package model

import io.ktor.client.call.body
import model.local.Character
import model.remote.character.CharacterApi
import model.remote.response.CharacterResponse.CharacterDTO
import model.remote.response.CharacterResponse.CharacterDTO.Companion.toEntity

class CharacterRepo(private val api: CharacterApi) {

    suspend fun getCharacters(): List<Character> {
        val response = api.fetchCharacters()
        return response.body<List<CharacterDTO>>().map { it.toEntity() }
    }
}