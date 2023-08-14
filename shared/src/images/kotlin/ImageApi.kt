interface ImageApi {
    suspend fun fetchImage(url: String): ByteArray?
}