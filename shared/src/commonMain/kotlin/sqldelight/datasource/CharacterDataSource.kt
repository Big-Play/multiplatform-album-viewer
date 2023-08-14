package sqldelight.datasource

import model.local.Character

interface CharacterDataSource {
    suspend fun getAllCharacters(): List<Character>
}