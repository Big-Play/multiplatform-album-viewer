package ui.characterList

import model.local.Character

object CharacterListContract {
    data class CharacterState(
        val character: List<Character> = listOf(),
        val isLoading: Boolean = false,
    )
}