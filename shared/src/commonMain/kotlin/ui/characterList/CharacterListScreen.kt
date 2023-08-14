package ui.characterList

import RemoteImage
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fetchImageAsByteArray
import model.local.Character
import moe.tlaster.precompose.viewmodel.viewModel
import toImageBitmap

@Composable
fun CharacterList(
    modifier: Modifier = Modifier,
    characterViewModel: CharacterViewModel = viewModel(CharacterViewModel::class) {
        CharacterViewModel()
    }
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primaryVariant),
        horizontalAlignment = CenterHorizontally
    ) {
        items(characterViewModel.state.character) { character: Character ->
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                backgroundColor = MaterialTheme.colors.surface.copy(alpha = .8f),
                shape = RoundedCornerShape(24.dp),
                elevation = 24.dp
            ) {
                Row {
                    if (character.image.isNotEmpty()) {
                        val imageByteArray = produceState<ByteArray?>(initialValue = null) {
                            value = fetchImageAsByteArray(character.image)
                        }
                        val imageBitmap: ImageBitmap? = imageByteArray.value?.toImageBitmap()
                        val aspectRatio: Float = imageBitmap?.let { it.width.toFloat() / it.height } ?: 1f
                        RemoteImage(
                            imageByteArray = imageByteArray.value,
                            contentDescription = "Character Image",
                            modifier = Modifier
                                .weight(weight = 1f)
                                .aspectRatio(aspectRatio)
                        )
                        Column(
                            modifier = Modifier
                                .padding(start = 6.dp)
                                .weight(weight = 1f)
                        ) {
                            Text(character.name)
                            Text(character.ancestry)
                            character.dateOfBirth?.let { Text(it) }
                            Text(character.gender)
                            Text(character.species)
                            Text(character.patronus)
                            Text(character.house)
                            Text(character.actor)
                        }
                    } else {
                        Row {
                            Text(
                                text = "No Image",
                                style = TextStyle(color = Color.Gray, fontSize = 16.sp),
                                modifier = Modifier.align(CenterVertically)
                            )
                            Column(
                                modifier = Modifier
                                    .padding(start = 6.dp)
                                    .weight(weight = 1f)
                            ) {
                                Text(character.name)
                                Text(character.ancestry)
                                character.dateOfBirth?.let { Text(it) }
                                Text(character.gender)
                                Text(character.species)
                                Text(character.patronus)
                                Text(character.house)
                                Text(character.actor)
                            }
                        }
                    }
                }
            }
        }
    }
}