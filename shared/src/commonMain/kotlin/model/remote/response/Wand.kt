package model.remote.response

import kotlinx.serialization.Serializable
import model.local.Wand


object WandResponse {

    @Serializable
    data class Wand(
        val core: String,
        val length: Double?,
        val wood: String
    ) {
        companion object {
            fun wandMapper(wand: Wand): model.local.Wand {
                return model.local.Wand(
                    core = wand.core,
                    length = wand.length,
                    wood = wand.wood
                )
            }
        }
    }
}
