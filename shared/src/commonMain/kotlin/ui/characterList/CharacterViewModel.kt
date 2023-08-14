package ui.characterList

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch
import model.CharacterRepo
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CharacterViewModel: ViewModel(), KoinComponent {

    private val repo: CharacterRepo by inject()
    var state by mutableStateOf(CharacterListContract.CharacterState())
        private set

    init {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val characters = repo.getCharacters()
            state = state.copy(character = characters, isLoading = false)
        }
    }
}