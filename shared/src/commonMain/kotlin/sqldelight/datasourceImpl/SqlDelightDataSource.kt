package sqldelight.datasourceImpl

import model.local.Character
import sqldelight.datasource.CharacterDataSource

class SqlDelightDataSource: CharacterDataSource {

    override suspend fun getAllCharacters(): List<Character> {
        TODO("Not yet implemented")
    }
}