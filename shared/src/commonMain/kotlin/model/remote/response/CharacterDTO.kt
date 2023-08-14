package model.remote.response


import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import model.local.Character
import model.remote.response.WandResponse.Wand

object CharacterResponse {

    @Serializable
    data class CharacterDTO(
        val actor: String,
        val alive: Boolean,
        @SerialName("alternate_names")
        val alternateNames: List<String>,
        val ancestry: String,
        val dateOfBirth: String?,
        val eyeColour: String,
        val gender: String,
        val hairColour: String,
        val hogwartsStaff: Boolean,
        val hogwartsStudent: Boolean,
        val house: String,
        val id: String,
        val image: String,
        val name: String,
        val patronus: String,
        val species: String,
        @Contextual
        val wand: Wand,
        val wizard: Boolean,
        val yearOfBirth: Int?
    ) {
        companion object {
            fun CharacterDTO.toEntity() = Character(
                actor = actor,
                alive = alive,
                alternateNames = alternateNames,
                ancestry = ancestry,
                dateOfBirth = dateOfBirth,
                eyeColour = eyeColour,
                gender = gender,
                hairColour = hairColour,
                hogwartsStaff = hogwartsStaff,
                hogwartsStudent = hogwartsStudent,
                house = house,
                id = id,
                image = image,
                name = name,
                patronus = patronus,
                species = species,
                wand = wand,
                wizard = wizard,
                yearOfBirth = yearOfBirth
            )
        }
    }
}
